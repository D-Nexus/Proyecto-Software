package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.DTO.proyectoDTO;
import proyecto.backend.service.IproyectoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos") //Centraliza los End-Point con el /api/proyectos Ejemplo url: localhost:8080/api/proyectos/getAll
public class proyectoController {

    @Autowired
    private IproyectoService proyectoService;

    @GetMapping("/getAll") //End-point
    public List<proyectoDTO> getAllProyectosDTOs() {
        return proyectoService.findAll();
    }

    @GetMapping("/SearchByID/{id}")
    public ResponseEntity<proyectoDTO> getProyectoDTOById(@PathVariable Long id) {
        Optional<proyectoDTO> proyectoDTO = proyectoService.findById(id);
        return proyectoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public proyectoDTO createProyectoDTO(@RequestBody proyectoDTO proyectoDTO) {
        return proyectoService.save(proyectoDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<proyectoDTO> updateProyectoDTO(@PathVariable Long id, @RequestBody proyectoDTO proyectoDTODetalles) {
        Optional<proyectoDTO> optionalProyectoDTO = proyectoService.findById(id);
        if (optionalProyectoDTO.isPresent()) {
            proyectoDTO proyectoDTO = optionalProyectoDTO.get();

            // Verificar cada campo antes de actualizarlo
            if (proyectoDTODetalles.getNombreProyecto() != null) {
                proyectoDTO.setNombreProyecto(proyectoDTODetalles.getNombreProyecto());
            }
            if (proyectoDTODetalles.getComuna() != null) {
                proyectoDTO.setComuna(proyectoDTODetalles.getComuna());
            }
            if (proyectoDTODetalles.getCantEmpleados() != null) {
                proyectoDTO.setCantEmpleados(proyectoDTODetalles.getCantEmpleados());
            }
            if (proyectoDTODetalles.getFechaInicio() != null) {
                proyectoDTO.setFechaInicio(proyectoDTODetalles.getFechaInicio());
            }
            if (proyectoDTODetalles.getFechaTerminoPactada() != null) {
                proyectoDTO.setFechaTerminoPactada(proyectoDTODetalles.getFechaTerminoPactada());
            }
            if (proyectoDTODetalles.getFechaTerminoReal() != null) {
                proyectoDTO.setFechaTerminoReal(proyectoDTODetalles.getFechaTerminoReal());
            }
            if (proyectoDTODetalles.getEstado() != null) {
                proyectoDTO.setEstado(proyectoDTODetalles.getEstado());
            }

            proyectoDTO updatedProyectoDTO = proyectoService.save(proyectoDTO);
            return ResponseEntity.ok(updatedProyectoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProyecto(@PathVariable Long id) {
        Optional<proyectoDTO> proyectoDTO = proyectoService.findById(id);
        if (proyectoDTO.isPresent()) {
            proyectoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}