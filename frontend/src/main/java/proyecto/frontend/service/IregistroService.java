package proyecto.frontend.service;

import proyecto.frontend.DTO.registroDTO;

import java.util.List;

public interface IregistroService {

    public List<registroDTO> findAllREST();

    public registroDTO findByIdREST(Long id);

    public registroDTO updateREST(Long id, registroDTO RegistroDTO);

    public registroDTO deleteREST(Long id);

    public registroDTO CalcularBonoREST(registroDTO RegistroDTO);
}
