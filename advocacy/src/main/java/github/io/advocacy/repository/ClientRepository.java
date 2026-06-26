package github.io.advocacy.repository;

import github.io.advocacy.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByGmail(String gmail);

    boolean existsByGmail(String gmail);

    boolean existsByCpf(String cpf);
}
