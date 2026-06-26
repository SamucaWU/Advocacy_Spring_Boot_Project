package github.io.advocacy.service;

import github.io.advocacy.DTOs.client.ClientResponseDTO;
import github.io.advocacy.DTOs.lawyer.LawyerResponseDTO;
import github.io.advocacy.DTOs.process.ProcessCreateDTO;
import github.io.advocacy.DTOs.process.ProcessResponseDTO;
import github.io.advocacy.DTOs.process.ProcessUpdateDTO;
import github.io.advocacy.Exception;
import github.io.advocacy.models.ClientEntity;
import github.io.advocacy.models.LawyerEntity;
import github.io.advocacy.models.ProcessEntity;
import github.io.advocacy.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private LawyerService lawyerService;

    // ── CREATE ──────────────────────────────────────────────────────────────

    public ProcessResponseDTO create(ProcessCreateDTO dto) {
        if (processRepository.existsByNumero(dto.numero())) {
            throw new Exception.ConflictException("Número de processo já cadastrado: " + dto.numero());
        }

        ClientEntity client = clientService.findEntityById(dto.clientId());
        LawyerEntity lawyer = lawyerService.findEntityById(dto.lawyerId());

        ProcessEntity entity = new ProcessEntity();
        entity.setNumero(dto.numero());
        entity.setTipo(dto.tipo());
        entity.setStatus(dto.status());
        entity.setDataAbertura(dto.dataAbertura());
        entity.setClient(client);
        entity.setLawyer(lawyer);

        return toResponseDTO(processRepository.save(entity));
    }

    // ── READ ALL ─────────────────────────────────────────────────────────────

    public List<ProcessResponseDTO> findAll() {
        return processRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── READ BY ID ───────────────────────────────────────────────────────────

    public ProcessResponseDTO findById(Long id) {
        return toResponseDTO(findEntityById(id));
    }

    // ── READ BY CLIENT ────────────────────────────────────────────────────────

    public List<ProcessResponseDTO> findByClientId(Long clientId) {
        clientService.findEntityById(clientId); // valida que o cliente existe
        return processRepository.findByClientId(clientId)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── READ BY LAWYER ────────────────────────────────────────────────────────

    public List<ProcessResponseDTO> findByLawyerId(Long lawyerId) {
        lawyerService.findEntityById(lawyerId); // valida que o advogado existe
        return processRepository.findByLawyerId(lawyerId)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── UPDATE ───────────────────────────────────────────────────────────────

    public ProcessResponseDTO update(Long id, ProcessUpdateDTO dto) {
        ProcessEntity entity = findEntityById(id);

        if (dto.tipo() != null) {
            entity.setTipo(dto.tipo());
        }
        if (dto.status() != null) {
            entity.setStatus(dto.status());
        }

        return toResponseDTO(processRepository.save(entity));
    }

    // ── DELETE ────────────────────────────────────────────────────────────────

    public void delete(Long id) {
        if (!processRepository.existsById(id)) {
            throw new Exception.ResourceNotFoundException("Processo não encontrado com id: " + id);
        }
        processRepository.deleteById(id);
    }

    // ── HELPER ────────────────────────────────────────────────────────────────

    public ProcessEntity findEntityById(Long id) {
        return processRepository.findById(id)
                .orElseThrow(() -> new Exception.ResourceNotFoundException("Processo não encontrado com id: " + id));
    }

    public ProcessResponseDTO toResponseDTO(ProcessEntity entity) {
        ClientResponseDTO clientDTO = new ClientResponseDTO(
                entity.getClient().getId(),
                entity.getClient().getNome(),
                entity.getClient().getCpf(),
                entity.getClient().getGmail(),
                entity.getClient().getTelefone()
        );
        LawyerResponseDTO lawyerDTO = lawyerService.toResponseDTO(entity.getLawyer());

        return new ProcessResponseDTO(
                entity.getId(),
                entity.getNumero(),
                entity.getTipo(),
                entity.getStatus(),
                entity.getDataAbertura(),
                clientDTO,
                lawyerDTO
        );
    }
}
