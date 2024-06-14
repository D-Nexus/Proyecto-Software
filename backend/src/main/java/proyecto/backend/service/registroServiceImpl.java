package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.registro;
import proyecto.backend.repository.registroRepository;

@Service
public class registroServiceImpl implements IregistroService {

    @Autowired
    private registroRepository registroRepository;

    @Override
    public List<registro> findAll() {
        return registroRepository.findAll();
    }

    @Override
    public Optional<registro> findById(Long id) {
        return registroRepository.findById(id);
    }

    @Override
    public registro save(registro Registro) {
        return registroRepository.save(Registro);
    }

    @Override
    public void deleteById(Long id) {
        registroRepository.deleteById(id);
    }

}
