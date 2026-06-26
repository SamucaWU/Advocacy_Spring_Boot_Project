package github.io.advocacy.controller;

import github.io.advocacy.DTOs.scheduling.SchedulingCreateDTO;
import github.io.advocacy.DTOs.scheduling.SchedulingResponseDTO;
import github.io.advocacy.DTOs.scheduling.SchedulingUpdateDTO;
import github.io.advocacy.service.SchedulingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedulings")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    // ── POST /api/schedulings ─────────────────────────────────────────────────
    @PostMapping
    public ResponseEntity<SchedulingResponseDTO> create(@RequestBody @Valid SchedulingCreateDTO dto) {
        SchedulingResponseDTO response = schedulingService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ── GET /api/schedulings ──────────────────────────────────────────────────
    @GetMapping
    public ResponseEntity<List<SchedulingResponseDTO>> findAll() {
        return ResponseEntity.ok(schedulingService.findAll());
    }

    // ── GET /api/schedulings/{id} ─────────────────────────────────────────────
    @GetMapping("/{id}")
    public ResponseEntity<SchedulingResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(schedulingService.findById(id));
    }

    // ── GET /api/schedulings/process/{processId} ───────────────────────────────
    @GetMapping("/process/{processId}")
    public ResponseEntity<List<SchedulingResponseDTO>> findByProcessId(@PathVariable Long processId) {
        return ResponseEntity.ok(schedulingService.findByProcessId(processId));
    }

    // ── GET /api/schedulings/lawyer/{lawyerId} ────────────────────────────────
    @GetMapping("/lawyer/{lawyerId}")
    public ResponseEntity<List<SchedulingResponseDTO>> findByLawyerId(@PathVariable Long lawyerId) {
        return ResponseEntity.ok(schedulingService.findByLawyerId(lawyerId));
    }

    // ── PUT /api/schedulings/{id} ─────────────────────────────────────────────
    @PutMapping("/{id}")
    public ResponseEntity<SchedulingResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Valid SchedulingUpdateDTO dto) {
        return ResponseEntity.ok(schedulingService.update(id, dto));
    }

    // ── DELETE /api/schedulings/{id} ──────────────────────────────────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        schedulingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
