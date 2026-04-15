package github.io.advocacy.models;

import github.io.advocacy.DTOs.scheduling.SchedulingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name="scheduling_db")
@NoArgsConstructor
public class SchedulingEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dataHora",nullable = false)
    private LocalDateTime dataHora;

    @Size(max = 255)
    @Column(name="descricao")
    private String descricao;

    @Column(name="status",nullable = false)
    @Enumerated(EnumType.STRING)
    private SchedulingStatus status; //Changed for enum version

    @ManyToOne
    @JoinColumn(name = "process_id")
    private ProcessEntity process;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private LawyerEntity lawyer;
}
