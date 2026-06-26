package github.io.advocacy.controller;

import github.io.advocacy.DTOs.process.ProcessCreateDTO;
import github.io.advocacy.DTOs.process.ProcessResponseDTO;
import github.io.advocacy.DTOs.process.ProcessUpdateDTO;
import github.io.advocacy.service.ProcessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processes")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    // ── POST /api/processes ───────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<ProcessResponseDTO> create(@RequestBody @Valid ProcessCreateDTO dto) {
        ProcessResponseDTO response = processService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ── GET /api/processes ────────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<ProcessResponseDTO>> findAll() {
        return ResponseEntity.ok(processService.findAll());
    }

    // ── GET /api/processes/{id} ───────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<ProcessResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(processService.findById(id));
    }

    // ── GET /api/processes/client/{clientId} ──────────────────────────────────
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ProcessResponseDTO>> findByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(processService.findByClientId(clientId));
    }

    // ── GET /api/processes/lawyer/{lawyerId} ──────────────────────────────────
    @GetMapping("/lawyer/{lawyerId}")
    public ResponseEntity<List<ProcessResponseDTO>> findByLawyerId(@PathVariable Long lawyerId) {
        return ResponseEntity.ok(processService.findByLawyerId(lawyerId));
    }

    // ── PUT /api/processes/{id} ───────────────────────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<ProcessResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid ProcessUpdateDTO dto) {
        return ResponseEntity.ok(processService.update(id, dto));
    }

    // ── DELETE /api/processes/{id} ────────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        processService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
