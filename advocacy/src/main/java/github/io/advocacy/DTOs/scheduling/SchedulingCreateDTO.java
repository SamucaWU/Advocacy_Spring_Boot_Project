package github.io.advocacy.DTOs.scheduling;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SchedulingCreateDTO(

        @NotBlank(message = "Data e hora obrigatória") LocalDateTime dataHora,
        String descricao,
        @NotBlank(message = "Status obrigatório") String status,
        @NotNull(message = "ID de processo inválido") Long processId,
        @NotNull(message = "ID de advogado inválido") Long lawyerId
) {}
