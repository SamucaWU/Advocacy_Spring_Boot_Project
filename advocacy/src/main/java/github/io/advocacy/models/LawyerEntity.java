package github.io.advocacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity // Mapeia automaticamente para o db
@Table(name = "lawyer_tb") // tabela de Advogado
@NoArgsConstructor
public class LawyerEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome",nullable = false)
    private String nome;

    @Column(name="oab",nullable = false)
    private String OAB;

    @Column(name="especialidade",nullable = false)
    private String especialidade;

    @Email
    @Column(name="email",unique = true,nullable = false)
    private String email;

    @Column(name="senha", nullable = false,length = 60)
    private String senha; // Added 13/03/26

    // Lawyer 1 ---- N Process
    @OneToMany(mappedBy = "lawyer")
    private List<ProcessEntity> process;

    // Lawyer 1 ---- N Scheduling
    @OneToMany(mappedBy = "lawyer")
    private List<SchedulingEntity> scheduling;
}
