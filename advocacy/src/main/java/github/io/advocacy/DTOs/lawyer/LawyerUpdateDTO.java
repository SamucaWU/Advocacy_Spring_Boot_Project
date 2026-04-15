package github.io.advocacy.DTOs.lawyer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LawyerUpdateDTO (

        String nome,

        @Pattern(
                regexp = "^[A-Z]{2}\\d{4,6}$|^\\d{4,6}/[A-Z]{2}$",
                message = "OAB inválida"
        )
        String OAB,

        @NotNull(message = "Especialidade inválido")
        LawyerSpeciality especialidade,

        @Email(message = "E-mail invalido")
        String gmail
) {}
