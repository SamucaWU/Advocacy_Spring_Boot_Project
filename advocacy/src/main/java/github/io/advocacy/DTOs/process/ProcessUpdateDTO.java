package github.io.advocacy.DTOs.process;

import jakarta.validation.constraints.NotNull;

public record ProcessUpdateDTO(

        @NotNull(message = "Tipo inválido") TypeProcess tipo,
        @NotNull(message = "Status inválido") StatusProcess status
) {
}
