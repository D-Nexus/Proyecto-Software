package proyecto.backend.service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.DTO.empleadoDTO;

public interface IempleadoService {

    List<empleadoDTO> findAll();

    Optional<empleadoDTO> findById(Long id);

    empleadoDTO save(empleadoDTO EmpleadoDTO);

    void deleteById(Long id);
}
