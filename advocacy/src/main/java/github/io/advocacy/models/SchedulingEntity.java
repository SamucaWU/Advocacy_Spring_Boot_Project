package github.io.advocacy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="scheduling_db")
public class SchedulingEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name="dataHora")
    @Getter
    @Setter
    private LocalDateTime dataHora;

    @Size(max = 255)
    @Column(name="descricao")
    @Getter
    @Setter
    private String descricao;

    @Column(name="status")
    @Getter
    @Setter
    private String status;

    @ManyToOne
    @JoinColumn(name = "process_id")
    @Getter
    @Setter
    private ProcessEntity process;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    @Getter
    @Setter
    private LawyerEntity lawyer;
}
