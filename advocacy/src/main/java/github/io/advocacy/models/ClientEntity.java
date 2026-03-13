package github.io.advocacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity // Mapeia automaticamente para o db
@Table(name = "tb_client") // Tabela do cliente
public class ClientEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Long Id; // Id do cliente

    @Column(name="nome")
    @Setter
    @Getter
    private String name;

    @Column(name= "cpf")
    @Setter
    @Getter
    private String cpf;

    @Email
    @Column(name="gmail")
    @NotBlank
    @Setter
    @Getter
    private String gmail;

    @Column(name="telefone")
    @Setter
    @Getter
    private String telefone;

    // Client 1 ---- N Process
    @Getter
    @Setter
    @OneToMany(mappedBy = "client")
    private List<ProcessEntity> process;

}
