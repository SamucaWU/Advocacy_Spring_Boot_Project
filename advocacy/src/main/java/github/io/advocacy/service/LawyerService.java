package github.io.advocacy.service;

import github.io.advocacy.DTOs.lawyer.LawyerCreateDTO;
import github.io.advocacy.DTOs.lawyer.LawyerResponseDTO;
import github.io.advocacy.DTOs.lawyer.LawyerUpdateDTO;
import github.io.advocacy.DTOs.lawyer.PasswordLawyerDTO;
import github.io.advocacy.Exception;
import github.io.advocacy.models.LawyerEntity;
import github.io.advocacy.repository.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LawyerService {

    @Autowired
    private LawyerRepository lawyerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // ── CREATE ──────────────────────────────────────────────────────────────

    public LawyerResponseDTO create(LawyerCreateDTO dto) {
        if (lawyerRepository.existsByGmail(dto.gmail())) {
            throw new Exception.ConflictException("E-mail já cadastrado: " + dto.gmail());
        }
        if (lawyerRepository.existsByOAB(dto.OAB())) {
            throw new Exception.ConflictException("OAB já cadastrada: " + dto.OAB());
        }

        LawyerEntity entity = new LawyerEntity();
        entity.setNome(dto.nome());
        entity.setOAB(dto.OAB());
        entity.setEspecialidade(dto.especialidade());
        entity.setGmail(dto.gmail());
        entity.setSenha(passwordEncoder.encode(dto.senha()));

        return toResponseDTO(lawyerRepository.save(entity));
    }

    // ── READ ALL ─────────────────────────────────────────────────────────────

    public List<LawyerResponseDTO> findAll() {
        return lawyerRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── READ BY ID ───────────────────────────────────────────────────────────

    public LawyerResponseDTO findById(Long id) {
        return toResponseDTO(findEntityById(id));
    }

    // ── UPDATE ───────────────────────────────────────────────────────────────

    public LawyerResponseDTO update(Long id, LawyerUpdateDTO dto) {
        LawyerEntity entity = findEntityById(id);

        if (dto.nome() != null && !dto.nome().isBlank()) {
            entity.setNome(dto.nome());
        }
        if (dto.OAB() != null && !dto.OAB().isBlank()) {
            if (!dto.OAB().equals(entity.getOAB()) && lawyerRepository.existsByOAB(dto.OAB())) {
                throw new Exception.ConflictException("OAB já cadastrada: " + dto.OAB());
            }
            entity.setOAB(dto.OAB());
        }
        if (dto.especialidade() != null) {
            entity.setEspecialidade(dto.especialidade());
        }
        if (dto.gmail() != null && !dto.gmail().isBlank()) {
            if (!dto.gmail().equals(entity.getGmail()) && lawyerRepository.existsByGmail(dto.gmail())) {
                throw new Exception.ConflictException("E-mail já cadastrado: " + dto.gmail());
            }
            entity.setGmail(dto.gmail());
        }

        return toResponseDTO(lawyerRepository.save(entity));
    }

    // ── UPDATE PASSWORD ───────────────────────────────────────────────────────

    public void updatePassword(Long id, PasswordLawyerDTO dto) {
        LawyerEntity entity = findEntityById(id);

        if (!passwordEncoder.matches(dto.currentPassword(), entity.getSenha())) {
            throw new Exception.InvalidPasswordException("Senha atual incorreta");
        }

        entity.setSenha(passwordEncoder.encode(dto.newPassword()));
        lawyerRepository.save(entity);
    }

    // ── DELETE ────────────────────────────────────────────────────────────────

    public void delete(Long id) {
        if (!lawyerRepository.existsById(id)) {
            throw new Exception.ResourceNotFoundException("Advogado não encontrado com id: " + id);
        }
        lawyerRepository.deleteById(id);
    }

    // ── HELPER ────────────────────────────────────────────────────────────────

    public LawyerEntity findEntityById(Long id) {
        return lawyerRepository.findById(id)
                .orElseThrow(() -> new Exception.ResourceNotFoundException("Advogado não encontrado com id: " + id));
    }

    public LawyerResponseDTO toResponseDTO(LawyerEntity entity) {
        return new LawyerResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getOAB(),
                entity.getEspecialidade(),
                entity.getGmail()
        );
    }
}
