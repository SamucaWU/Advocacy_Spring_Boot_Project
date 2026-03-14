package github.io.advocacy.repository;

import github.io.advocacy.models.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {
}
