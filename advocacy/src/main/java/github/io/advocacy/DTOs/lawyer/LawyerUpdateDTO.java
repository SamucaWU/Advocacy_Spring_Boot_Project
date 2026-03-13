package github.io.advocacy.DTOs.lawyer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LawyerUpdateDTO (

        @NotBlank(message = "Nome inválido") String nome,
        @NotBlank(message = "Especialidade inválido") String especialidade,
        @Email(message = "E-mail ou senha invalido(s)") String email
) {}
