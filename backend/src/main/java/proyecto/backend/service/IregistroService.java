package proyecto.backend.service;

import java.util.List;
import java.util.Optional;
import proyecto.backend.DTO.registroDTO;

public interface IregistroService {

    List<registroDTO> findAll();

    Optional<registroDTO> findById(Long id);

    registroDTO save(registroDTO registro);

    void deleteById(Long id);
}
