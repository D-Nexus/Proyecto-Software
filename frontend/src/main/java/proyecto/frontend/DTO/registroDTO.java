package proyecto.frontend.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class registroDTO {

    private Long id;
    private String recibeBono;
    private String porcentaje;
    private Double montoBono;
    private String estado;
    private String fechaPago;
    private empleadoDTO empleado;
    private proyectoDTO proyecto;
}
