package github.io.advocacy.DTOs.process;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProcessCreateDTO(

        @NotBlank(message = "Número obrigatório") String numero,
        @NotBlank(message = "Tipo obrigatório") String tipo,
        @NotBlank(message = "Status obrigatório") String status,
        @NotBlank(message = "Data obrigatória") LocalDate dataAbertura,
        @NotNull(message = "ID de cliente inválido") Long clientId,
        @NotNull(message = "ID de advogado inválido") Long lawyerId
) {}
