package proyecto.backend.service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.Empleado;

public interface IEmpleadoService {

    List<Empleado> findAll();

    Optional<Empleado> findById(Long id);

    Empleado save(Empleado Empleado);

    void deleteById(Long id);
}
