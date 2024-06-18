package proyecto.backend.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import proyecto.backend.DTO.registroDTO;
import proyecto.backend.entity.registro;

public interface IregistroService {

    List<registroDTO> findAll();

    Optional<registroDTO> findById(Long id);

    registroDTO save(registroDTO registro);

    void deleteById(Long id);

    registroDTO calcularBono(registroDTO registro);
}
