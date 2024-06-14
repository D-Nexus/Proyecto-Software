package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.RegistroServiceImpl;
import proyecto.backend.entity.Registro;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    @Autowired
    private RegistroServiceImpl registroService;

    @GetMapping("/getAll")
    public List<Registro> getAllregistros() {
        return registroService.findAll();
    }

    @GetMapping("/SearchById/{id}")
    public ResponseEntity<Registro> getRegistroById(@PathVariable Long id) {
        Optional<Registro> Registro = registroService.findById(id);
        return  Registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Registro createRegistro(@RequestBody Registro Registro) {
        return registroService.save(Registro);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Registro> updateRegistro(@PathVariable Long id, @RequestBody Registro registroDetalles) {
        Optional<Registro> optionalRegistro = registroService.findById(id);
        if (optionalRegistro.isPresent()) {
            Registro Registro = optionalRegistro.get();
            Registro.setFechaPago(registroDetalles.getFechaPago());
            Registro.setRecibeBono(registroDetalles.getRecibeBono());
            Registro.setMontoBono(registroDetalles.getMontoBono());
            Registro.setPorcentaje(registroDetalles.getPorcentaje());
            Registro.setEstado(registroDetalles.getEstado());
            Registro.setEmpleado(registroDetalles.getEmpleado());
            Registro.setProyecto(registroDetalles.getProyecto());
            proyecto.backend.entity.Registro updatedRegistro = registroService.save(Registro);
            return ResponseEntity.ok(updatedRegistro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        Optional<Registro> Registro = registroService.findById(id);
        if (Registro.isPresent()) {
            registroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

