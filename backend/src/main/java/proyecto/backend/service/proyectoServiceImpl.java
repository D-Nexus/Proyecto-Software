package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import proyecto.backend.DTO.proyectoDTO;
import proyecto.backend.entity.proyecto;
import proyecto.backend.repository.proyectoRepository;
import proyecto.backend.repository.registroRepository;

@Service
public class proyectoServiceImpl implements IproyectoService {

    @Autowired
    private proyectoRepository ProyectoRepository;

    @Autowired
    private registroRepository RegistroRepository;

    public List<proyectoDTO> findAll() {
        List<proyecto> TodosLosProyectos = (List<proyecto>) ProyectoRepository.findAll();
        List<proyectoDTO> listDto = new ArrayList<proyectoDTO>();
        for (proyecto l : TodosLosProyectos) {
            listDto.add(l.toDTO());
        }
        return listDto;
    }

    public Optional<proyectoDTO> findById(Long id) {
        Optional<proyecto> BuscarPorID = ProyectoRepository.findById(id);
        proyecto DevolverProyecto = BuscarPorID.get();
        proyectoDTO dto = DevolverProyecto.toDTO();
        return Optional.ofNullable(dto);
    }

    public proyectoDTO save(proyectoDTO Proyectodto) {
        if (containsNumber(Proyectodto.getNombreProyecto()) || containsNumber(Proyectodto.getComuna()) || containsNumber(Proyectodto.getEstado())) {
            throw new IllegalArgumentException("No puede contener números.");
        }
        proyecto GuardarProyecto = ProyectoRepository.save(Proyectodto.toEntity()); //Convertir proyectoDTO a proyecto con el metodo toEntity
        return GuardarProyecto.toDTO(); // Se devuelve convirtiendo el proyecto a DTO
    }

    public void deleteById(Long Id) {
        Long Registro_a_eliminar = RegistroRepository.findRegistroIdByProyectoId(Id);
        if (Registro_a_eliminar != null){
            RegistroRepository.deleteById(Registro_a_eliminar);
        }
        ProyectoRepository.deleteById(Id);
    }
    private boolean containsNumber(String str) {
        return str != null && str.matches(".*\\d.*");
    }
}