package github.io.advocacy.DTOs.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PasswordClientDTO(

        @NotBlank(message = "Senha Atual Obrigatória")
        String currentPassword,

        @NotBlank(message = "Nova senha obrigatória")
        @Size(min = 8,message = "Mínimo 8 caracteres")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
                message = "A senha deve conter maiúscula, minúscula e número"
        ) String newPassword
) {}
