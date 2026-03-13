package github.io.advocacy.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity // Mapeia automaticamente para o db
@Table(name="process_tb")
@NoArgsConstructor
public class ProcessEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero",nullable = false)
    private String numero;

    @Column(name="tipo",nullable = false)
    private String tipo;

    @Column(name="status",nullable = false)
    private String status;

    @Column(name="dataAbertura",nullable = false)
    private LocalDate dataAbertura;


    // Connection with ClientEntity
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    // Connection with LawyerEntity
    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private LawyerEntity lawyer;

    // Process 1 ---- N schedulings
    @OneToMany(mappedBy = "process")
    private List<SchedulingEntity> scheduling;
}
