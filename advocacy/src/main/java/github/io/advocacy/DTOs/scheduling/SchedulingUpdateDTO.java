package github.io.advocacy.DTOs.scheduling;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record SchedulingUpdateDTO(

        @NotBlank(message = "Data e hora inválida") LocalDateTime dataHora,
        String descricao,
        @NotBlank(message = "Status inválido") String status
) {}
