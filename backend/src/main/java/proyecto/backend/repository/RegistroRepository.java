package proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.backend.entity.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
