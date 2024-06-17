package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import proyecto.backend.DTO.registroDTO;
import proyecto.backend.entity.registro;
import proyecto.backend.repository.registroRepository;
import proyecto.backend.repository.proyectoRepository;
import proyecto.backend.repository.empleadoRepository;


@Service
public class registroServiceImpl implements IregistroService {

    @Autowired
    private registroRepository RegistroRepository;



    public List<registroDTO> findAll() {
        List<registro> TodosLosregistros = (List<registro>) RegistroRepository.findAll();
        List<registroDTO> listDto = new ArrayList<registroDTO>();
        for (registro l : TodosLosregistros) {
            listDto.add(l.toDTO());
        }
        return listDto;
    }

    public Optional<registroDTO> findById(Long id) {
        Optional<registro> BuscarPorID = RegistroRepository.findById(id);
        registro DevolverRegistro = BuscarPorID.get();
        registroDTO dto = DevolverRegistro.toDTO();
        return Optional.ofNullable(dto);
    }

    public registroDTO save(registroDTO Registrodto) {
        registro Guardarregistro = RegistroRepository.save(Registrodto.toEntity()); //Convertir registroDTO a registro con el metodo toEntity
        return Guardarregistro.toDTO(); // Se devuelve convirtiendo el registro a DTO
    }

    public void deleteById(Long Id) {
        RegistroRepository.ClearEmpleadoIdYProyectoIdByRegistroId(Id);
        RegistroRepository.deleteById(Id);
    }
}
