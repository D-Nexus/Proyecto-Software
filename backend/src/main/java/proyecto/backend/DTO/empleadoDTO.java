package proyecto.backend.DTO;
import lombok.Data;
import proyecto.backend.entity.empleado;

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
    private LocalDate fechaIngreso;
    private Double sueldoConBono;

    public empleado toEntity() {
        empleado e = new empleado();
        e.setId(this.getId());
        e.setNombre(this.getNombre());
        e.setApellidoPaterno(this.getApellidoPaterno());
        e.setApellidoMaterno(this.getApellidoMaterno());
        e.setTipoCargo(this.getTipoCargo());
        e.setSueldoBruto(this.getSueldoBruto());
        e.setTipoContrato(this.getTipoContrato());
        e.setFechaIngreso(this.getFechaIngreso());
        e.setSueldoConBono(this.getSueldoConBono());
        return e;
    }
}