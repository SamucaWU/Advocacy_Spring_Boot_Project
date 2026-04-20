package github.io.advocacy.DTOs.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDTO(

        @NotBlank(message = "E-mail obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String gmail,

        @NotBlank(message = "Senha obrigatória")
        String senha
) {}
