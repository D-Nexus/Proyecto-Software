package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService {

    @Autowired
    private proyecto.backend.repository.ProyectoRepository ProyectoRepository;

    @Override
    public List<Proyecto> findAll() {
        return ProyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> findById(Long id) {
        return ProyectoRepository.findById(id);
    }

    @Override
    public Proyecto save(Proyecto Proyecto) {
        return ProyectoRepository.save(Proyecto);
    }

    @Override
    public void deleteById(Long id) {
        ProyectoRepository.deleteById(id);
    }
}