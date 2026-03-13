package github.io.advocacy.repository;

import github.io.advocacy.models.SchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Integer> {
}
