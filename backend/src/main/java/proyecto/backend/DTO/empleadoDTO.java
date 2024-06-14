package proyecto.backend.DTO;
import lombok.Data;
import proyecto.backend.entity.empleado;

import java.time.LocalDate;
import java.util.Date;

@Data
public class empleadoDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaIngreso;
    private Double sueldoBruto;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoCargo;
    private String tipoContrato;
    private Double sueldoConBono;

    public empleado toEntity() {
        empleado e = new empleado();
        e.setId(this.getId());
        e.setNombre(this.getNombre());
        e.setFechaIngreso(this.getFechaIngreso());
        e.setSueldoBruto(this.getSueldoBruto());
        e.setApellidoPaterno(this.getApellidoPaterno());
        e.setApellidoMaterno(this.getApellidoMaterno());
        e.setTipoCargo(this.getTipoCargo());
        e.setTipoContrato(this.getTipoContrato());
        e.setSueldoConBono(this.getSueldoConBono());
        return e;
    }
}