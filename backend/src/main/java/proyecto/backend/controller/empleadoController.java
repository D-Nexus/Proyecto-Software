package proyecto.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.empleadoServiceImpl;

import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.empleado;

@RestController
@RequestMapping("/api/empleados")
public class empleadoController {

    @Autowired
    private empleadoServiceImpl empleadoService;

    @GetMapping("/getAll")
    public List<empleado> getAllEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/SearchByID/{id}")
    public ResponseEntity<empleado> getEmpleadoById(@PathVariable Long id) {
        Optional<empleado> Empleado = empleadoService.findById(id);
        return Empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public empleado createEmpleado(@RequestBody empleado Empleado) {
        return empleadoService.save(Empleado);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<empleado> updateEmpleado(@PathVariable Long id, @RequestBody empleado empleadoDetalles) {
        Optional<empleado> optionalEmpleado = empleadoService.findById(id);
        if (optionalEmpleado.isPresent()) {
            empleado Empleado = optionalEmpleado.get();
            Empleado.setNombre(empleadoDetalles.getNombre());
            Empleado.setApellidoPaterno(empleadoDetalles.getApellidoPaterno());
            Empleado.setApellidoMaterno(empleadoDetalles.getApellidoMaterno());
            Empleado.setTipoCargo(empleadoDetalles.getTipoCargo());
            Empleado.setSueldoBruto(empleadoDetalles.getSueldoBruto());
            Empleado.setFechaIngreso(empleadoDetalles.getFechaIngreso());
            Empleado.setTipoContrato(empleadoDetalles.getTipoContrato());
            Empleado.setSueldoConBono(empleadoDetalles.getSueldoConBono());
            empleado updatedEmpleado = empleadoService.save(Empleado);
            return ResponseEntity.ok(updatedEmpleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        Optional<empleado> Empleado = empleadoService.findById(id);
        if (Empleado.isPresent()) {
            empleadoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*
    @PostMapping("/asociarProyecto")
    public ResponseEntity<Void> asociarEmpleadoAProyecto(@RequestBody AsociarEmpleadoProyectoDTO dto) {
        empleadoService.asociarEmpleadoAProyecto(dto.getEmpleadoId(), dto.getProyectoId());
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}