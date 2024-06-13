package proyecto.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.entity.empleado;
import proyecto.backend.entity.proyecto;
import proyecto.backend.repository.empleadoRepository;
import proyecto.backend.repository.proyectoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class empleadoServiceImpl implements IempleadoService{

    @Autowired
    private empleadoRepository EmpleadoRepository;
    private proyectoRepository ProyectoRepository;

    public List<empleado> findAll() {
        return EmpleadoRepository.findAll();
    }

    public Optional<empleado> findById(Long id) {
        return EmpleadoRepository.findById(id);
    }

    public empleado save(empleado empleado) {
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
