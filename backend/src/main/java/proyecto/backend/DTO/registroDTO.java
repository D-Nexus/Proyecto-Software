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
    private LocalDate fechaPago;
    private String recibeBono;
    private Double montoBono;
    private String porcentaje;
    private String estado;
    private empleadoDTO empleado;
    private proyectoDTO proyecto;

    public registro toEntity() {
        registro r = new registro();
        r.setId(this.getId());
        r.setFechaPago(this.getFechaPago());
        r.setRecibeBono(this.getRecibeBono());
        r.setMontoBono(this.getMontoBono());
        r.setPorcentaje(this.getPorcentaje());
        r.setEstado(this.getEstado());
        r.setEmpleado(empleado.toEntity());
        r.setProyecto(proyecto.toEntity());
        return r;
    }
}
