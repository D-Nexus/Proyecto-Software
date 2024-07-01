package proyecto.frontend.service;

import proyecto.frontend.DTO.proyectoDTO;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface IproyectoService {

    public List<proyectoDTO> findAllREST();

    public proyectoDTO findByIdREST(Long id);

    public proyectoDTO saveREST(proyectoDTO ProyectoDTO);

    public proyectoDTO updateREST(Long id, proyectoDTO ProyectoDTO);

    public proyectoDTO deleteREST(Long id);

    ByteArrayInputStream generateExcelReport(String reportType);
}
