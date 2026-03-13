package github.io.advocacy.DTOs.client;

public record ClientCreateDTO(

        String nome,
        String cpf,
        String email,
        String telefone
) {}
