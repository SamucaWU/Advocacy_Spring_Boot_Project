package github.io.advocacy.DTOs.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record ClientCreateDTO(

        @NotBlank(message = "Nome obrigatório")
        String nome,

        @Pattern(
                regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$|^\\d{11}$", //Regex CPF
                message = "CPF inválido (use 000.000.000-00 ou apenas números)"
        )@CPF
        @NotBlank(message = "CPF obrigatório")
        String cpf,

        @NotBlank(message = "E-mail obrigatório")
        @Email(message = "E-mail ou senha inválido(s)")
        String gmail,

        @Pattern(
                regexp = "^(\\(?\\d{2}\\)?\\s?)?\\d{4,5}-?\\d{4}$", //Regex telephone
                message = "Telefone inválido"
        )@NotBlank(message = "Número de telefone obrigatório")
        String telefone,

        @NotBlank(message = "Senha obrigatória")
        @Size(min = 8)
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$", //Regex Password
                message = "A senha deve conter maiúscula, minúscula e número"
        ) String senha
) {}
