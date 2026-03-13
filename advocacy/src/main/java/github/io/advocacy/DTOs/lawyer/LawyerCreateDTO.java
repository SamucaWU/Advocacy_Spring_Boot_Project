package github.io.advocacy.DTOs.lawyer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LawyerCreateDTO(

    @NotBlank(message = "Nome obrigatório") String nome,
    @NotBlank(message = "OAB obrigatória") String OAB,
    @NotBlank(message = "Especialidade obrigatória") String especialidade,
    @NotBlank(message = "E-mail obrigatório") @Email(message = "E-mail ou senha inválido(s)") String email,
    @NotBlank(message = "Senha obrigatória") String senha

) {}

