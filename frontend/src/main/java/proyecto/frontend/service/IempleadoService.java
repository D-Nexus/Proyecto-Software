package proyecto.frontend.service;
import proyecto.frontend.DTO.empleadoDTO;

import java.util.List;

public interface IempleadoService {
    public List<empleadoDTO> findAllREST();

    public empleadoDTO findByIdREST(Long id);

    public empleadoDTO saveREST(empleadoDTO empleadoDTO);

    public empleadoDTO updateREST(Long id, empleadoDTO empleadoDTO);

    public empleadoDTO deleteREST(Long id);
}
