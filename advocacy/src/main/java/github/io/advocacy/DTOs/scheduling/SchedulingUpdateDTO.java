package github.io.advocacy.DTOs.scheduling;

import java.time.LocalDateTime;

public record SchedulingUpdateDTO(

        LocalDateTime dataHora,
        String descricao,
        String status
) {}
