package github.io.advocacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "tb_client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
