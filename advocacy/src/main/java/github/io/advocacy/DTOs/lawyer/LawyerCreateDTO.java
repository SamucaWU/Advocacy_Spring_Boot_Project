package github.io.advocacy.DTOs.lawyer;

import jakarta.validation.constraints.*;

public record LawyerCreateDTO(

    @NotBlank(message = "Nome obrigatório")
    String nome,

    @Pattern (
            regexp = "^[A-Z]{2}\\d{4,6}$|^\\d{4,6}/[A-Z]{2}$", //Regex OAB
            message = "OAB inválida (ex: DF123456 ou 123456/DF)"
    )@NotBlank(message = "OAB obrigatória")
    String OAB,

    @NotNull(message = "Especialidade obrigatória")
    LawyerSpeciality especialidade,

    @NotBlank(message = "E-mail obrigatório")
    @Email(message = "E-mail ou senha inválido(s)")
    String gmail,

    @NotBlank(message = "Senha obrigatória")
    @Size(min = 8)
    String senha

) {}

