package github.io.advocacy.repository;

import github.io.advocacy.models.LawyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LawyerRepository extends JpaRepository<LawyerEntity, Long> {

    Optional<LawyerEntity> findByGmail(String gmail);

    boolean existsByGmail(String gmail);

    boolean existsByOAB(String oab);
}
