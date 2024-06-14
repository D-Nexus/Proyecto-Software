package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.ProyectoServiceImpl;
import proyecto.backend.entity.Proyecto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoServiceImpl proyectoService;

    @GetMapping("/getAll")
    public List<Proyecto> getAllProyectos() {
        return proyectoService.findAll();
    }

    @GetMapping("/searchById/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable Long id) {
        Optional<Proyecto> Proyecto = proyectoService.findById(id);
        return Proyecto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Proyecto createProyecto(@RequestBody Proyecto Proyecto) {
        return proyectoService.save(Proyecto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Proyecto> updateProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoDetalles) {
        Optional<Proyecto> optionalProyecto = proyectoService.findById(id);
        if (optionalProyecto.isPresent()) {
            Proyecto Proyecto = optionalProyecto.get();
            Proyecto.setNombreProyecto(proyectoDetalles.getNombreProyecto());
            Proyecto.setFechaInicio(proyectoDetalles.getFechaInicio());
            Proyecto.setFechaTerminoPactada(proyectoDetalles.getFechaTerminoPactada());
            Proyecto.setFechaTerminoReal(proyectoDetalles.getFechaTerminoReal());
            Proyecto.setEstado(proyectoDetalles.getEstado());
            Proyecto.setComuna(proyectoDetalles.getComuna());
            Proyecto.setCantEmpleados(proyectoDetalles.getCantEmpleados());
            proyecto.backend.entity.Proyecto updatedProyecto = proyectoService.save(Proyecto);
            return ResponseEntity.ok(updatedProyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        Optional<Proyecto> Proyecto = proyectoService.findById(id);
        if (Proyecto.isPresent()) {
            proyectoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}