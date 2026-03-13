package github.io.advocacy.DTOs.scheduling;
import github.io.advocacy.DTOs.lawyer.LawyerResponseDTO;
import github.io.advocacy.DTOs.process.ProcessResponseDTO;
import java.time.LocalDateTime;

public record SchedulingResponseDTO(

        Long id,
        LocalDateTime dataHora,
        String descricao,
        String status,
        ProcessResponseDTO process,
        LawyerResponseDTO lawyer
) {
}
