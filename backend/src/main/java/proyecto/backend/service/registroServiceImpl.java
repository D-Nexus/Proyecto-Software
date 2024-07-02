package proyecto.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import proyecto.backend.DTO.registroDTO;
import proyecto.backend.entity.proyecto;
import proyecto.backend.entity.registro;
import proyecto.backend.repository.registroRepository;
import proyecto.backend.DTO.proyectoDTO;
import proyecto.backend.DTO.empleadoDTO;


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

    public void deleteById(Long Id) {
        RegistroRepository.ClearEmpleadoIdYProyectoIdByRegistroId(Id);
        RegistroRepository.deleteById(Id);
    }

    public registroDTO calcularBono(registroDTO registro) {

        boolean ExisteEnBD = RegistroRepository.existsByEmpleadoAndProyecto(registro.getEmpleado().getNombre(), registro.getEmpleado().getApellidoPaterno(), registro.getProyecto().getNombreProyecto());
        if (ExisteEnBD == true) {
            throw new IllegalArgumentException("Ya existe un registro con el mismo empleado y proyecto");
        }

        empleadoDTO empleado = registro.getEmpleado();
        proyectoDTO proyecto = registro.getProyecto();

        if (empleado == null || proyecto == null) {
            throw new IllegalArgumentException("Empleado y proyecto no pueden ser nulos");
        }

        BigDecimal bono = BigDecimal.ZERO;
        BigDecimal sueldoBruto = empleado.getSueldoBruto() != null ? BigDecimal.valueOf(empleado.getSueldoBruto()) : BigDecimal.ZERO;
        LocalDate fechaIngresoEmpleado = empleado.getFechaIngreso();
        LocalDate fechaInicioProyecto = proyecto.getFechaInicio();
        LocalDate fechaTerminoPactada = proyecto.getFechaTerminoPactada();
        LocalDate fechaTerminoReal = proyecto.getFechaTerminoReal();
        String estado = proyecto.getEstado().toLowerCase();

        if (fechaIngresoEmpleado == null || fechaInicioProyecto == null || fechaTerminoPactada == null || fechaTerminoReal == null || estado == "terminado") {
            throw new IllegalArgumentException("Error hay datos que no existen");
        }

        // Calcula los años que el empleado lleva en la empresa antes del inicio del proyecto
        long anosEnEmpresaAntesDelProyecto = ChronoUnit.YEARS.between(fechaIngresoEmpleado, fechaInicioProyecto);

        // Condiciones para calcular el bono basado en las fechas y el estado del proyecto
        if (fechaTerminoReal.isEqual(fechaTerminoPactada)) {
            // Fecha de entrega es igual a la fecha pactada se agrega un bono del 10%
            bono = sueldoBruto.multiply(new BigDecimal("0.10"));
            registro.setMontoBono(Double.valueOf(String.valueOf(bono)));
            registro.setPorcentaje("10%");
            registro.setRecibeBono("Si");
            registro.setEstado("Aprobado");
        } else if (fechaTerminoReal.isBefore(fechaTerminoPactada) && estado.equals("terminado")) {
            // Fecha de entrega es anticipada se agrega un bono del 25%
            bono = sueldoBruto.multiply(new BigDecimal("0.25"));
            registro.setMontoBono(Double.valueOf(String.valueOf(bono)));
            registro.setPorcentaje("25%");
            registro.setRecibeBono("Si");
            registro.setEstado("Aprobado");
        } else if (fechaTerminoReal.isAfter(fechaTerminoPactada)) {
            // Fecha de entrega es posterior a la fecha pactada, no aplica bonificación
            bono = BigDecimal.ZERO;
            registro.setMontoBono(Double.valueOf(String.valueOf(bono)));
            registro.setPorcentaje("0%");
            registro.setRecibeBono("No");
            registro.setEstado("Rechazado");
        }

        // Condición para bonificación adicional por antigüedad
        if (anosEnEmpresaAntesDelProyecto >= 2 && !bono.equals(BigDecimal.ZERO) && !estado.equals("Rechazado")){
            bono = sueldoBruto.multiply(new BigDecimal("0.45"));
            registro.setMontoBono(Double.valueOf(String.valueOf(bono)));
            registro.setPorcentaje("45%");
        }
        // Guardamos el registro en la base de datos
        registro GuardarRegistro = RegistroRepository.save(registro.toEntity());

        return GuardarRegistro.toDTO();
    }
}
