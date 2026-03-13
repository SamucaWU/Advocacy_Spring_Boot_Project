package github.io.advocacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity // Mapeia automaticamente para o db
@Table(name = "lawyer_tb") // tabela de Advogado
public class LawyerEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name="nome")
    @Getter
    @Setter
    private String nome;

    @Column(name="oab")
    @Getter
    @Setter
    private String OAB;

    @Column(name="especialidade")
    @Getter
    @Setter
    private String especialidade;

    @Email
    @Column(name="email")
    @NotBlank
    @Getter
    @Setter
    private String email;

    // Lawyer 1 ---- N Process
    @OneToMany(mappedBy = "lawyer")
    @Getter
    @Setter
    private List<ProcessEntity> process;

    // Lawyer 1 ---- N Scheduling
    @OneToMany(mappedBy = "lawyer")
    @Getter
    @Setter
    private List<SchedulingEntity> scheduling;
}
