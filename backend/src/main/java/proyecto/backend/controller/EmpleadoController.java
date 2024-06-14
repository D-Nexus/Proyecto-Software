package proyecto.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.EmpleadoServiceImpl;

import java.util.List;
import java.util.Optional;
import proyecto.backend.entity.Empleado;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @GetMapping("/getAll")
    public List<Empleado> getAllEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/SearchByID/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        Optional<Empleado> Empleado = empleadoService.findById(id);
        return Empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Empleado createEmpleado(@RequestBody Empleado Empleado) {
        return empleadoService.save(Empleado);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDetalles) {
        Optional<Empleado> optionalEmpleado = empleadoService.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleado Empleado = optionalEmpleado.get();
            Empleado.setNombre(empleadoDetalles.getNombre());
            Empleado.setApellidoPat(empleadoDetalles.getApellidoPat());
            Empleado.setApellidoMat(empleadoDetalles.getApellidoMat());
            Empleado.setTipoCargo(empleadoDetalles.getTipoCargo());
            Empleado.setSueldoBruto(empleadoDetalles.getSueldoBruto());
            Empleado.setFechaIngreso(empleadoDetalles.getFechaIngreso());
            Empleado.setTipoContrato(empleadoDetalles.getTipoContrato());
            proyecto.backend.entity.Empleado updatedEmpleado = empleadoService.save(Empleado);
            return ResponseEntity.ok(updatedEmpleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id) {
        Optional<Empleado> Empleado = empleadoService.findById(id);
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