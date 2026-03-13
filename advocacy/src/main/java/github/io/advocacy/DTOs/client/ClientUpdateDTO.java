package github.io.advocacy.DTOs.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientUpdateDTO(

        @NotBlank(message = "Nome inválido") String nome,
        @Email(message = "E-mail ou senha invalido(s)") String email,
        @NotBlank(message = "Número de telefone inválido") String telefone
) {}
