package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import proyecto.backend.DTO.proyectoDTO;
import proyecto.backend.entity.proyecto;
import proyecto.backend.repository.proyectoRepository;

@Service
public class proyectoServiceImpl implements IproyectoService {

    @Autowired
    private proyectoRepository ProyectoRepository;

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
        proyecto GuardarProyecto = ProyectoRepository.save(Proyectodto.toEntity()); //Convertir proyectoDTO a proyecto con el metodo toEntity
        return GuardarProyecto.toDTO(); // Se devuelve convirtiendo el proyecto a DTO
    }

    public void deleteById(Long Id) {
        ProyectoRepository.deleteById(Id);
    }
}