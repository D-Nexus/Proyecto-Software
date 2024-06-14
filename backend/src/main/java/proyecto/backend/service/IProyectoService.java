package proyecto.backend.service;

import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.Proyecto;

public interface IProyectoService {

    List<Proyecto> findAll();

    Optional<Proyecto> findById(Long id);

    Proyecto save(Proyecto Proyecto);

    void deleteById(Long id);
}
