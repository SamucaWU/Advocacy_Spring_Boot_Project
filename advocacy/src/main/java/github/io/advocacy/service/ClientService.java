package github.io.advocacy.service;

import github.io.advocacy.DTOs.client.ClientCreateDTO;
import github.io.advocacy.DTOs.client.ClientResponseDTO;
import github.io.advocacy.DTOs.client.ClientUpdateDTO;
import github.io.advocacy.DTOs.client.PasswordClientDTO;
import github.io.advocacy.Exception;
import github.io.advocacy.models.ClientEntity;
import github.io.advocacy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // ── CREATE ──────────────────────────────────────────────────────────────

    public ClientResponseDTO create(ClientCreateDTO dto) {
        if (clientRepository.existsByGmail(dto.gmail())) {
            throw new Exception.ConflictException("E-mail já cadastrado: " + dto.gmail());
        }
        if (clientRepository.existsByCpf(dto.cpf())) {
            throw new Exception.ConflictException("CPF já cadastrado");
        }

        ClientEntity entity = new ClientEntity();
        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setGmail(dto.gmail());
        entity.setTelefone(dto.telefone());
        entity.setSenha(passwordEncoder.encode(dto.senha()));

        ClientEntity saved = clientRepository.save(entity);
        return toResponseDTO(saved);
    }

    // ── READ ALL ─────────────────────────────────────────────────────────────

    public List<ClientResponseDTO> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    // ── READ BY ID ───────────────────────────────────────────────────────────

    public ClientResponseDTO findById(Long id) {
        ClientEntity entity = findEntityById(id);
        return toResponseDTO(entity);
    }

    // ── UPDATE ───────────────────────────────────────────────────────────────

    public ClientResponseDTO update(Long id, ClientUpdateDTO dto) {
        ClientEntity entity = findEntityById(id);

        if (dto.nome() != null && !dto.nome().isBlank()) {
            entity.setNome(dto.nome());
        }
        if (dto.gmail() != null && !dto.gmail().isBlank()) {
            if (!dto.gmail().equals(entity.getGmail()) && clientRepository.existsByGmail(dto.gmail())) {
                throw new Exception.ConflictException("E-mail já cadastrado: " + dto.gmail());
            }
            entity.setGmail(dto.gmail());
        }
        if (dto.telefone() != null && !dto.telefone().isBlank()) {
            entity.setTelefone(dto.telefone());
        }

        return toResponseDTO(clientRepository.save(entity));
    }

    // ── UPDATE PASSWORD ───────────────────────────────────────────────────────

    public void updatePassword(Long id, PasswordClientDTO dto) {
        ClientEntity entity = findEntityById(id);

        if (!passwordEncoder.matches(dto.currentPassword(), entity.getSenha())) {
            throw new Exception.InvalidPasswordException("Senha atual incorreta");
        }

        entity.setSenha(passwordEncoder.encode(dto.newPassword()));
        clientRepository.save(entity);
    }

    // ── DELETE ────────────────────────────────────────────────────────────────

    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new Exception.ResourceNotFoundException("Cliente não encontrado com id: " + id);
        }
        clientRepository.deleteById(id);
    }

    // ── HELPER ────────────────────────────────────────────────────────────────

    public ClientEntity findEntityById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new Exception.ResourceNotFoundException("Cliente não encontrado com id: " + id));
    }

    private ClientResponseDTO toResponseDTO(ClientEntity entity) {
        return new ClientResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getGmail(),
                entity.getTelefone()
        );
    }
}
