package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.registroServiceImpl;
import proyecto.backend.entity.registro;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registros")
public class registroController {

    @Autowired
    private registroServiceImpl registroService;

    @GetMapping("/getAll")
    public List<registro> getAllregistros() {
        return registroService.findAll();
    }

    @GetMapping("/SearchById/{id}")
    public ResponseEntity<registro> getRegistroById(@PathVariable Long id) {
        Optional<registro> Registro = registroService.findById(id);
        return  Registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public registro createRegistro(@RequestBody registro Registro) {
        return registroService.save(Registro);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<registro> updateRegistro(@PathVariable Long id, @RequestBody registro registroDetalles) {
        Optional<registro> optionalRegistro = registroService.findById(id);
        if (optionalRegistro.isPresent()) {
            registro Registro = optionalRegistro.get();
            Registro.setRecibeBono(registroDetalles.getRecibeBono());
            Registro.setPorcentaje(registroDetalles.getPorcentaje());
            Registro.setMontoBono(registroDetalles.getMontoBono());
            Registro.setEstado(registroDetalles.getEstado());
            Registro.setFechaPago(registroDetalles.getFechaPago());
            Registro.setEmpleado(registroDetalles.getEmpleado());
            Registro.setProyecto(registroDetalles.getProyecto());
            registro updatedRegistro = registroService.save(Registro);
            return ResponseEntity.ok(updatedRegistro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        Optional<registro> Registro = registroService.findById(id);
        if (Registro.isPresent()) {
            registroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

