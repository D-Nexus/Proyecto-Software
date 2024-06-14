package proyecto.frontend.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class registroDTO {

    private Long id;
    private String fechaPago;
    private String recibeBono;
    private Double montoBono;
    private String porcentaje;
    private String estado;
    private empleadoDTO empleado;
    private proyectoDTO proyecto;
}
