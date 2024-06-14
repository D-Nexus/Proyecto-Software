package proyecto.frontend.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class proyectoDTO {
    private Long id;
    private String nombreProyecto;
    private String fechaInicio;
    private String fechaTerminoPactada;
    private String fechaTerminoReal;
    private String estado;
    private String comuna;
    private Integer cantEmpleados;
}
