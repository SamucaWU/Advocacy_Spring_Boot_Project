package github.io.advocacy.DTOs.process;
import java.time.LocalDate;

public record ProcessCreateDTO(

        String numero,
        String tipo,
        String status,
        LocalDate dataAbertura,
        Long clientId,
        Long lawyerId
) {}
