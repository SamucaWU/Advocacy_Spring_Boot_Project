package github.io.advocacy.DTOs.process;

import jakarta.validation.constraints.NotBlank;

public record ProcessUpdateDTO(

        @NotBlank(message = "Tipo inválido") String tipo,
        @NotBlank(message = "Status inválido") String status
) {
}
