package proyecto.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.backend.entity.empleado;

@Repository
public interface empleadoRepository extends JpaRepository<empleado, Long> {
}
