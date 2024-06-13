package proyecto.backend.service;

import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.proyecto;

public interface IproyectoService {

    List<proyecto> findAll();

    Optional<proyecto> findById(Long id);

    proyecto save(proyecto Proyecto);

    void deleteById(Long id);
}
