package proyecto.backend.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import proyecto.backend.entity.registro;

import java.util.List;

@Repository
public interface registroRepository extends JpaRepository<registro, Long> {

    @Query("SELECT r.id FROM registro r WHERE r.empleado.id = :empleadoId")
    Long findRegistroIdByEmpleadoId(@Param("empleadoId") Long empleadoId);

    @Query("SELECT r.id FROM registro r WHERE r.proyecto.id = :proyectoId")
    Long findRegistroIdByProyectoId(@Param("proyectoId") Long proyectoId);

    @Transactional
    @Modifying
    @Query("UPDATE registro r SET r.empleado = NULL, r.proyecto = NULL WHERE r.id = :registroId")
    void ClearEmpleadoIdYProyectoIdByRegistroId(@Param("registroId") Long registroId);

}
