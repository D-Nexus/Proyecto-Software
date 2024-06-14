package proyecto.backend.DTO;

import lombok.Data;

import java.time.LocalDate;

import proyecto.backend.entity.Proyecto;

@Data
public class ProyectoDTO {

    private Long id;
    private String nombreProyecto;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminoPactada;
    private LocalDate fechaTerminoReal;
    private String estado;
    private String comuna;
    private Integer cantEmpleados;

    public Proyecto toEntity() {
        Proyecto p = new Proyecto();
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
