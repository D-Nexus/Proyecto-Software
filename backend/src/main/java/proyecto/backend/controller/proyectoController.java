package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.proyectoServiceImpl;
import proyecto.backend.entity.proyecto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class proyectoController {

    @Autowired
    private proyectoServiceImpl proyectoService;

    @GetMapping("/getAll")
    public List<proyecto> getAllProyectos() {
        return proyectoService.findAll();
    }

    @GetMapping("/searchById/{id}")
    public ResponseEntity<proyecto> getProyectoById(@PathVariable Long id) {
        Optional<proyecto> Proyecto = proyectoService.findById(id);
        return Proyecto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public proyecto createProyecto(@RequestBody proyecto Proyecto) {
        return proyectoService.save(Proyecto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<proyecto> updateProyecto(@PathVariable Long id, @RequestBody proyecto proyectoDetalles) {
        Optional<proyecto> optionalProyecto = proyectoService.findById(id);
        if (optionalProyecto.isPresent()) {
            proyecto Proyecto = optionalProyecto.get();
            Proyecto.setNombreProyecto(proyectoDetalles.getNombreProyecto());
            Proyecto.setFechaInicio(proyectoDetalles.getFechaInicio());
            Proyecto.setFechaTerminoPactada(proyectoDetalles.getFechaTerminoPactada());
            Proyecto.setFechaTerminoReal(proyectoDetalles.getFechaTerminoReal());
            Proyecto.setEstado(proyectoDetalles.getEstado());
            Proyecto.setComuna(proyectoDetalles.getComuna());
            Proyecto.setCantEmpleados(proyectoDetalles.getCantEmpleados());
            proyecto updatedProyecto = proyectoService.save(Proyecto);
            return ResponseEntity.ok(updatedProyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        Optional<proyecto> Proyecto = proyectoService.findById(id);
        if (Proyecto.isPresent()) {
            proyectoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}