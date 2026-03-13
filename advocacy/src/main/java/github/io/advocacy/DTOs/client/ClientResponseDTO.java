package github.io.advocacy.DTOs.client;

public record ClientResponseDTO(

        Long id,
        String nome,
        String cpf,
        String email,
        String telefone

) {}
