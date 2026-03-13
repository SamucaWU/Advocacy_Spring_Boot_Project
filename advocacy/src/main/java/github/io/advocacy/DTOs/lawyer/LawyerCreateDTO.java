package github.io.advocacy.DTOs.lawyer;

public record LawyerCreateDTO(

    String nome,
    String OAB,
    String especialidade,
    String email
) {}

