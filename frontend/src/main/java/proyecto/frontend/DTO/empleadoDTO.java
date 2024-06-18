package proyecto.frontend.DTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class empleadoDTO {

    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoCargo;
    private Double sueldoBruto;
    private String tipoContrato;
    private String fechaIngreso;
}

