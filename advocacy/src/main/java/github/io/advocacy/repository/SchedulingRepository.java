package github.io.advocacy.repository;

import github.io.advocacy.models.SchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {

    List<SchedulingEntity> findByProcessId(Long processId);

    List<SchedulingEntity> findByLawyerId(Long lawyerId);
}
