package proyecto.backend.service;

import java.util.List;
import java.util.Optional;

import proyecto.backend.DTO.proyectoDTO;

public interface IproyectoService {

    List<proyectoDTO> findAll();

    Optional<proyectoDTO> findById(Long id);

    proyectoDTO save(proyectoDTO ProyectoDTO);

    void deleteById(Long id);
}
