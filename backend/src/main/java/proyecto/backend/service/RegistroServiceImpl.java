package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.Registro;
import proyecto.backend.repository.RegistroRepository;

@Service
public class RegistroServiceImpl implements IRegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    @Override
    public List<Registro> findAll() {
        return registroRepository.findAll();
    }

    @Override
    public Optional<Registro> findById(Long id) {
        return registroRepository.findById(id);
    }

    @Override
    public Registro save(Registro Registro) {
        return registroRepository.save(Registro);
    }

    @Override
    public void deleteById(Long id) {
        registroRepository.deleteById(id);
    }

}
