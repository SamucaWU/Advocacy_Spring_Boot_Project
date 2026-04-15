package github.io.advocacy.DTOs.lawyer;

public record LawyerResponseDTO(

        Long id,
        String nome,
        String OAB,
        LawyerSpeciality especialidade,
        String gmail
) {}
