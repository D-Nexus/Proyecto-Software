package proyecto.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.backend.DTO.empleadoDTO;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaIngreso;
    private Double sueldoBruto;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoCargo;
    private String tipoContrato;
    private Double sueldoConBono;


    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private Set<registro> registros;

    public empleadoDTO toDTO(){
        empleadoDTO empleadoDTO = new empleadoDTO();
        empleadoDTO.setId(id);
        empleadoDTO.setNombre(nombre);
        empleadoDTO.setFechaIngreso(fechaIngreso);
        empleadoDTO.setSueldoBruto(sueldoBruto);
        empleadoDTO.setApellidoPaterno(apellidoPaterno);
        empleadoDTO.setApellidoMaterno(apellidoMaterno);
        empleadoDTO.setTipoCargo(tipoCargo);
        empleadoDTO.setTipoContrato(tipoContrato);
        empleadoDTO.setSueldoConBono(sueldoConBono);
        return empleadoDTO;
    }
}