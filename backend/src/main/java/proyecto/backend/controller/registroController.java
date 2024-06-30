package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.IregistroService;
import proyecto.backend.DTO.registroDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registros")
public class registroController {

    @Autowired
    private IregistroService registroService;

    @GetMapping("/getAll")
    public List<registroDTO> getAllregistros() {
        return registroService.findAll();
    }

    @GetMapping("/SearchByID/{id}")
    public ResponseEntity<registroDTO> getRegistroById(@PathVariable Long id) {
        Optional<registroDTO> Registro = registroService.findById(id);
        return  Registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<registroDTO> updateRegistro(@PathVariable Long id, @RequestBody registroDTO registroDetalles) {
        Optional<registroDTO> optionalRegistro = registroService.findById(id);
        if (optionalRegistro.isPresent()) {
            registroDTO Registro = optionalRegistro.get();
            Registro.setRecibeBono(registroDetalles.getRecibeBono());
            Registro.setPorcentaje(registroDetalles.getPorcentaje());
            Registro.setMontoBono(registroDetalles.getMontoBono());
            Registro.setEstado(registroDetalles.getEstado());
            Registro.setFechaPago(registroDetalles.getFechaPago());
            Registro.setEmpleado(registroDetalles.getEmpleado());
            Registro.setProyecto(registroDetalles.getProyecto());
            registroDTO updatedRegistro = registroService.calcularBono(Registro);
            return ResponseEntity.ok(updatedRegistro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRegistro(@PathVariable Long id) {
        Optional<registroDTO> Registro = registroService.findById(id);
        if (Registro.isPresent()) {
            registroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/calcularBono")
    public registroDTO obtenerBono(@RequestBody registroDTO RegistroDTO) {
         return registroService.calcularBono(RegistroDTO);
    }
}

