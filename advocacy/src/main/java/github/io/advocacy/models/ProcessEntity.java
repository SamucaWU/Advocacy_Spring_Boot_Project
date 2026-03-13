package github.io.advocacy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity // Mapeia automaticamente para o db
@Table(name="process_tb")
public class ProcessEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name="numero")
    @Getter
    @Setter
    private String numero;

    @Column(name="tipo")
    @Getter
    @Setter
    private String tipo;

    @Column(name="status")
    @Getter
    @Setter
    private String status;

    @Column(name="dataAbertura")
    @Getter
    @Setter
    private LocalDate dataAbertura;


    // Connection with ClientEntity
    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter
    @Setter
    private ClientEntity client;

    // Connection with LawyerEntity
    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    @Getter
    @Setter
    private LawyerEntity lawyer;

    // Process 1 ---- N schedulings
    @OneToMany(mappedBy = "process")
    @Getter
    @Setter
    private List<SchedulingEntity> scheduling;
}
