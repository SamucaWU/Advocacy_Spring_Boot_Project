package github.io.advocacy.DTOs.scheduling;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record SchedulingUpdateDTO(

        @Future(message = "Adicionar nova data e hora")
        LocalDateTime dataHora,

        @Size(max = 255)
        String descricao,

        @NotNull(message = "Status inválido")
        SchedulingStatus status
) {}
