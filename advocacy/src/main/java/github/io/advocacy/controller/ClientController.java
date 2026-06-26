package github.io.advocacy.controller;

import github.io.advocacy.DTOs.client.ClientCreateDTO;
import github.io.advocacy.DTOs.client.ClientResponseDTO;
import github.io.advocacy.DTOs.client.ClientUpdateDTO;
import github.io.advocacy.DTOs.client.PasswordClientDTO;
import github.io.advocacy.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // ── POST /api/clients ────────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody @Valid ClientCreateDTO dto) {
        ClientResponseDTO response = clientService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ── GET /api/clients ─────────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    // ── GET /api/clients/{id} ─────────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    // ── PUT /api/clients/{id} ─────────────────────────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid ClientUpdateDTO dto) {
        return ResponseEntity.ok(clientService.update(id, dto));
    }

    // ── PATCH /api/clients/{id}/password ─────────────────────────────────────
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody @Valid PasswordClientDTO dto) {
        clientService.updatePassword(id, dto);
        return ResponseEntity.noContent().build();
    }

    // ── DELETE /api/clients/{id} ──────────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
