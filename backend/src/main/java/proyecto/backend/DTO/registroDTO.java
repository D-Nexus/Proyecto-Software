package proyecto.backend.DTO;

import lombok.Data;
import proyecto.backend.entity.registro;
import proyecto.backend.entity.proyecto;
import proyecto.backend.entity.empleado;

import java.time.LocalDate;
import java.util.Date;

@Data
public class registroDTO {

    private Long id;
    private String recibeBono;
    private String porcentaje;
    private Double montoBono;
    private String estado;
    private LocalDate fechaPago;
    private empleadoDTO empleado;
    private proyectoDTO proyecto;

    public registro toEntity() {
        registro r = new registro();
        r.setId(this.getId());
        r.setRecibeBono(this.getRecibeBono());
        r.setPorcentaje(this.getPorcentaje());
        r.setMontoBono(this.getMontoBono());
        r.setEstado(this.getEstado());
        r.setFechaPago(this.getFechaPago());
        r.setEmpleado(empleado.toEntity());
        r.setProyecto(proyecto.toEntity());
        return r;
    }
}
