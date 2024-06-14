package proyecto.backend.DTO;
import lombok.Data;
import proyecto.backend.entity.Empleado;

import java.time.LocalDate;

@Data
public class EmpleadoDTO {

    private Long id;
    private String nombre;
    private LocalDate fechaIngreso;
    private Double sueldoBruto;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoCargo;
    private String tipoContrato;
    private Double sueldoConBono;

    public Empleado toEntity() {
        Empleado e = new Empleado();
        e.setId(this.getId());
        e.setNombre(this.getNombre());
        e.setFechaIngreso(this.getFechaIngreso());
        e.setSueldoBruto(this.getSueldoBruto());
        e.setApellidoPat(this.getApellidoPaterno());
        e.setApellidoMat(this.getApellidoMaterno());
        e.setTipoCargo(this.getTipoCargo());
        e.setTipoContrato(this.getTipoContrato());
        return e;
    }
}