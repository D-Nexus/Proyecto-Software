package proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.backend.entity.proyecto;

@Repository
public interface proyectoRepository extends JpaRepository<proyecto, Long> {
}
