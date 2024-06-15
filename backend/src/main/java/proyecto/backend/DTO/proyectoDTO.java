package proyecto.backend.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import proyecto.backend.entity.proyecto;

@Data
public class proyectoDTO {

    private Long id;
    private String nombreProyecto;
    private String comuna;
    private Integer cantEmpleados;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminoPactada;
    private LocalDate fechaTerminoReal;
    private String estado;

    public proyecto toEntity() {
        proyecto p = new proyecto();
        p.setId(this.getId());
        p.setNombreProyecto(this.getNombreProyecto());
        p.setComuna(this.getComuna());
        p.setCantEmpleados(this.getCantEmpleados());
        p.setFechaInicio(this.getFechaInicio());
        p.setFechaTerminoPactada(this.getFechaTerminoPactada());
        p.setFechaTerminoReal(this.getFechaTerminoReal());
        p.setEstado(this.getEstado());
        return p;
    }
}
