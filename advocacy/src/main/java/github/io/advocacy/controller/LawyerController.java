package github.io.advocacy.controller;

import github.io.advocacy.DTOs.lawyer.LawyerCreateDTO;
import github.io.advocacy.DTOs.lawyer.LawyerResponseDTO;
import github.io.advocacy.DTOs.lawyer.LawyerUpdateDTO;
import github.io.advocacy.DTOs.lawyer.PasswordLawyerDTO;
import github.io.advocacy.service.LawyerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService lawyerService;

    // ── POST /api/lawyers ────────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<LawyerResponseDTO> create(@RequestBody @Valid LawyerCreateDTO dto) {
        LawyerResponseDTO response = lawyerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ── GET /api/lawyers ─────────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<LawyerResponseDTO>> findAll() {
        return ResponseEntity.ok(lawyerService.findAll());
    }

    // ── GET /api/lawyers/{id} ─────────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<LawyerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(lawyerService.findById(id));
    }

    // ── PUT /api/lawyers/{id} ─────────────────────────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<LawyerResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid LawyerUpdateDTO dto) {
        return ResponseEntity.ok(lawyerService.update(id, dto));
    }

    // ── PATCH /api/lawyers/{id}/password ──────────────────────────────────────
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody @Valid PasswordLawyerDTO dto) {
        lawyerService.updatePassword(id, dto);
        return ResponseEntity.noContent().build();
    }

    // ── DELETE /api/lawyers/{id} ──────────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lawyerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
