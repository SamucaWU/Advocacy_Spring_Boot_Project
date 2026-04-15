package github.io.advocacy.DTOs.lawyer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PasswordLawyerDTO(

        @NotBlank(message = "Senha atual obrigatória")
        String currentPassword,

        @NotBlank(message = "Nova senha obrigatória")
        @Size(min = 8,message = "Mínimo 8 caracteres")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$",
                message = "Senha deve conter maiúscula, minúscula e número"
        )
        String newPassword
) {}
