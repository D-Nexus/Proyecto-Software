package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.proyecto;
import proyecto.backend.repository.proyectoRepository;

@Service
public class proyectoServiceImpl implements IproyectoService {

    @Autowired
    private proyectoRepository ProyectoRepository;

    @Override
    public List<proyecto> findAll() {
        return ProyectoRepository.findAll();
    }

    @Override
    public Optional<proyecto> findById(Long id) {
        return ProyectoRepository.findById(id);
    }

    @Override
    public proyecto save(proyecto Proyecto) {
        return ProyectoRepository.save(Proyecto);
    }

    @Override
    public void deleteById(Long id) {
        ProyectoRepository.deleteById(id);
    }
}