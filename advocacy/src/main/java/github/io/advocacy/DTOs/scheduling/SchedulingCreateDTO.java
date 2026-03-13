package github.io.advocacy.DTOs.scheduling;
import java.time.LocalDateTime;

public record SchedulingCreateDTO(

        LocalDateTime dataHora,
        String descricao,
        String status,
        Long processId,
        Long lawyerId
) {}
