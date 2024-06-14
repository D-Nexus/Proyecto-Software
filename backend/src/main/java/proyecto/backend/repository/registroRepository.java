package proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.backend.entity.registro;

@Repository
public interface registroRepository extends JpaRepository<registro, Long> {
}
