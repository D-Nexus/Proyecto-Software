package proyecto.backend.DTO;

import lombok.Data;
import proyecto.backend.entity.Registro;

import java.time.LocalDate;

@Data
public class RegistroDTO {

    private Long id;
    private LocalDate fechaPago;
    private String recibeBono;
    private Double montoBono;
    private String porcentaje;
    private String estado;
    private EmpleadoDTO empleado;
    private ProyectoDTO proyecto;

    public Registro toEntity() {
        Registro r = new Registro();
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
