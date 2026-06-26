package github.io.advocacy.repository;

import github.io.advocacy.models.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {

    List<ProcessEntity> findByClientId(Long clientId);

    List<ProcessEntity> findByLawyerId(Long lawyerId);

    boolean existsByNumero(String numero);
}
