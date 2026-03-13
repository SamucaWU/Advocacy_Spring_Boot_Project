package github.io.advocacy.DTOs.process;
import github.io.advocacy.DTOs.client.ClientResponseDTO;
import github.io.advocacy.DTOs.lawyer.LawyerResponseDTO;
import java.time.LocalDate;

public record ProcessResponseDTO(

        Long id,
        String numero,
        String tipo,
        String status,
        LocalDate dataAbertura,
        ClientResponseDTO client,
        LawyerResponseDTO lawyer
) {}
