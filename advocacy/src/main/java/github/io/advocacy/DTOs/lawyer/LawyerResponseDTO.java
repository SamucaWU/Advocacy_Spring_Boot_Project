package github.io.advocacy.DTOs.lawyer;

public record LawyerResponseDTO(

        Long id,
        String nome,
        String OAB,
        String especialidade,
        String email
) {}
