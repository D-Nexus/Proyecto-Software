package proyecto.backend.service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.empleado;

public interface IempleadoService {

    List<empleado> findAll();

    Optional<empleado> findById(Long id);

    empleado save(empleado Empleado);

    void deleteById(Long id);
}
