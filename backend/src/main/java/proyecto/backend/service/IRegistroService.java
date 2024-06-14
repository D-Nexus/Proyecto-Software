package proyecto.backend.service;

import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.Registro;

public interface IRegistroService {

    List<Registro> findAll();

    Optional<Registro> findById(Long id);

    Registro save(Registro registro);

    void deleteById(Long id);
}
