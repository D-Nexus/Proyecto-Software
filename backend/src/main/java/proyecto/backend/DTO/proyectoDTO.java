package proyecto.backend.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import proyecto.backend.entity.proyecto;

@Data
public class proyectoDTO {

    private Long id;
    private String nombreProyecto;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminoPactada;
    private LocalDate fechaTerminoReal;
    private String estado;
    private String comuna;
    private Integer cantEmpleados;

    public proyecto toEntity() {
        proyecto p = new proyecto();
        p.setId(this.getId());
        p.setNombreProyecto(this.getNombreProyecto());
        p.setFechaInicio(this.getFechaInicio());
        p.setFechaTerminoPactada(this.getFechaTerminoPactada());
        p.setFechaTerminoReal(this.getFechaTerminoReal());
        p.setEstado(this.getEstado());
        p.setComuna(this.getComuna());
        p.setCantEmpleados(this.getCantEmpleados());
        return p;
    }
}
