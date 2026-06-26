package github.io.advocacy.service;

import github.io.advocacy.DTOs.scheduling.SchedulingCreateDTO;
import github.io.advocacy.DTOs.scheduling.SchedulingResponseDTO;
import github.io.advocacy.DTOs.scheduling.SchedulingUpdateDTO;
import github.io.advocacy.Exception;
import github.io.advocacy.models.LawyerEntity;
import github.io.advocacy.models.ProcessEntity;
import github.io.advocacy.models.SchedulingEntity;
import github.io.advocacy.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private ProcessService processService;

    @Autowired
    private LawyerService lawyerService;

    // ── CREATE ──────────────────────────────────────────────────────────────

    public SchedulingResponseDTO create(SchedulingCreateDTO dto) {
        ProcessEntity process = processService.findEntityById(dto.processId());
        LawyerEntity lawyer = lawyerService.findEntityById(dto.lawyerId());

        SchedulingEntity entity = new SchedulingEntity();
        entity.setDataHora(dto.dataHora());
        entity.setDescricao(dto.descricao());
        entity.setStatus(dto.status());
        entity.setProcess(process);
        entity.setLawyer(lawyer);

        return toResponseDTO(schedulingRepository.save(entity));
    }

    // ── READ ALL ─────────────────────────────────────────────────────────────

    public List<SchedulingResponseDTO> findAll() {
        return schedulingRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── READ BY ID ───────────────────────────────────────────────────────────

    public SchedulingResponseDTO findById(Long id) {
        return toResponseDTO(findEntityById(id));
    }

    // ── READ BY PROCESS ───────────────────────────────────────────────────────

    public List<SchedulingResponseDTO> findByProcessId(Long processId) {
        processService.findEntityById(processId); // valida que o processo existe
        return schedulingRepository.findByProcessId(processId)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── READ BY LAWYER ────────────────────────────────────────────────────────

    public List<SchedulingResponseDTO> findByLawyerId(Long lawyerId) {
        lawyerService.findEntityById(lawyerId); // valida que o advogado existe
        return schedulingRepository.findByLawyerId(lawyerId)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── UPDATE ───────────────────────────────────────────────────────────────

    public SchedulingResponseDTO update(Long id, SchedulingUpdateDTO dto) {
        SchedulingEntity entity = findEntityById(id);

        if (dto.dataHora() != null) {
            entity.setDataHora(dto.dataHora());
        }
        if (dto.descricao() != null) {
            entity.setDescricao(dto.descricao());
        }
        if (dto.status() != null) {
            entity.setStatus(dto.status());
        }

        return toResponseDTO(schedulingRepository.save(entity));
    }

    // ── DELETE ────────────────────────────────────────────────────────────────

    public void delete(Long id) {
        if (!schedulingRepository.existsById(id)) {
            throw new Exception.ResourceNotFoundException("Agendamento não encontrado com id: " + id);
        }
        schedulingRepository.deleteById(id);
    }

    // ── HELPER ────────────────────────────────────────────────────────────────

    public SchedulingEntity findEntityById(Long id) {
        return schedulingRepository.findById(id)
                .orElseThrow(() -> new Exception.ResourceNotFoundException("Agendamento não encontrado com id: " + id));
    }

    private SchedulingResponseDTO toResponseDTO(SchedulingEntity entity) {
        return new SchedulingResponseDTO(
                entity.getId(),
                entity.getDataHora(),
                entity.getDescricao(),
                entity.getStatus(),
                processService.toResponseDTO(entity.getProcess()),
                lawyerService.toResponseDTO(entity.getLawyer())
        );
    }
}
