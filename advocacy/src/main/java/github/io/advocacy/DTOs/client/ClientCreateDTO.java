package github.io.advocacy.DTOs.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientCreateDTO(

        @NotBlank(message = "Nome obrigatório") String nome,
        @NotBlank(message = "CPF obrigatório") String cpf,
        @NotBlank(message = "E-mail obrigatório") @Email(message = "E-mail ou senha inválido(s)") String email,
        @NotBlank(message = "Número de telefone obrigatório") String telefone,
        @NotBlank(message = "Senha obrigatória") String senha
) {}
