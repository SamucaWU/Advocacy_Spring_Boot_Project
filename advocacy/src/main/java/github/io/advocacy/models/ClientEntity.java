package github.io.advocacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity // Mapeia automaticamente para o db
@Table(name = "tb_client") // Tabela do cliente
@NoArgsConstructor
public class ClientEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Id do cliente

    @Column(name="nome",nullable = false)
    private String nome;

    @Column(name= "cpf",nullable = false)
    private String cpf;

    @Email
    @Column(name="gmail",unique = true,nullable = false) // unique = Single E-mail
    private String gmail;

    @Column(name="telefone",nullable = false)
    private String telefone;

    @Column(name="senha", nullable = false,length = 60)
    private String senha; // Added 13/03/26

    // Client 1 ---- N Process
    @OneToMany(mappedBy = "client")
    private List<ProcessEntity> process;

}
