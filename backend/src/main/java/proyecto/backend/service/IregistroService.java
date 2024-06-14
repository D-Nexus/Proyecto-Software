package proyecto.backend.service;

import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.registro;

public interface IregistroService {

    List<registro> findAll();

    Optional<registro> findById(Long id);

    registro save(registro registro);

    void deleteById(Long id);
}
