package proyecto.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.entity.Empleado;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private proyecto.backend.repository.EmpleadoRepository EmpleadoRepository;
    private proyecto.backend.repository.ProyectoRepository ProyectoRepository;

    public List<Empleado> findAll() {
        return EmpleadoRepository.findAll();
    }

    public Optional<Empleado> findById(Long id) {
        return EmpleadoRepository.findById(id);
    }

    public Empleado save(Empleado empleado) {
        return EmpleadoRepository.save(empleado);
    }

    public void deleteById(Long id) {
        EmpleadoRepository.deleteById(id);
    }
    /*
    public void asociarEmpleadoAProyecto(Long empleadoId, Long proyectoId) {
        empleado Empleado = EmpleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id " + empleadoId));
        proyecto Proyecto = ProyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto not found with id " + proyectoId));

        Empleado.getProyectos().add(Proyecto);
        Proyecto.getEmpleados().add(Empleado);

        EmpleadoRepository.save(Empleado);
        ProyectoRepository.save(Proyecto);
    }*/
}
