package proyecto.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto.backend.service.IempleadoService;
import proyecto.backend.DTO.empleadoDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class empleadoController {

    @Autowired
    private IempleadoService empleadoService;

    @GetMapping("/getAll")
    public List<empleadoDTO> getAllempleadoDTOs() {
        return empleadoService.findAll();
    }

    @GetMapping("/SearchByID/{id}")
    public ResponseEntity<empleadoDTO> getempleadoDTOById(@PathVariable Long id) {
        Optional<empleadoDTO> EmpleadoDTO = empleadoService.findById(id);
        return EmpleadoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public empleadoDTO createempleadoDTO(@RequestBody empleadoDTO EmpleadoDTO) {
        return empleadoService.save(EmpleadoDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<empleadoDTO> updateempleadoDTO(@PathVariable Long id, @RequestBody empleadoDTO EmpleadoDTODetalles) {
        Optional<empleadoDTO> optionalempleadoDTO = empleadoService.findById(id);
        if (optionalempleadoDTO.isPresent()) {
            empleadoDTO EmpleadoDTO = optionalempleadoDTO.get();

            // Verificar cada campo antes de actualizarlo
            if (EmpleadoDTODetalles.getNombre() != null) {
                EmpleadoDTO.setNombre(EmpleadoDTODetalles.getNombre());
            }
            if (EmpleadoDTODetalles.getApellidoPaterno() != null) {
                EmpleadoDTO.setApellidoPaterno(EmpleadoDTODetalles.getApellidoPaterno());
            }
            if (EmpleadoDTODetalles.getApellidoMaterno() != null) {
                EmpleadoDTO.setApellidoMaterno(EmpleadoDTODetalles.getApellidoMaterno());
            }
            if (EmpleadoDTODetalles.getTipoCargo() != null) {
                EmpleadoDTO.setTipoCargo(EmpleadoDTODetalles.getTipoCargo());
            }
            if (EmpleadoDTODetalles.getSueldoBruto() != null) {
                EmpleadoDTO.setSueldoBruto(EmpleadoDTODetalles.getSueldoBruto());
            }
            if (EmpleadoDTODetalles.getFechaIngreso() != null) {
                EmpleadoDTO.setFechaIngreso(EmpleadoDTODetalles.getFechaIngreso());
            }
            if (EmpleadoDTODetalles.getTipoContrato() != null) {
                EmpleadoDTO.setTipoContrato(EmpleadoDTODetalles.getTipoContrato());
            }

            empleadoDTO updatedempleadoDTO = empleadoService.save(EmpleadoDTO);
            return ResponseEntity.ok(updatedempleadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteempleadoDTO(@PathVariable Long id) {
        Optional<empleadoDTO> EmpleadoDTO = empleadoService.findById(id);
        if (EmpleadoDTO.isPresent()) {
            empleadoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}