package github.io.advocacy.DTOs.scheduling;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record SchedulingCreateDTO(

        @NotNull(message = "Data e hora obrigatória")
        @Future(message = "Adicionar data e hora")
        LocalDateTime dataHora,

        @NotBlank
        @Size(max=255)
        String descricao,

        @NotNull(message = "Status obrigatório")
        SchedulingStatus status,

        @NotNull(message = "ID de processo inválido")
        Long processId,

        @NotNull(message = "ID de advogado inválido")
        Long lawyerId
) {}
