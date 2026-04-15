package github.io.advocacy.DTOs.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientUpdateDTO(

        String nome,
        @Email(message = "E-mail invalido") String gmail,
        String telefone
) {}
