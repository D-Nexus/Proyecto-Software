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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-incremental
    private Long id; //PK

    //Columnas
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoCargo;
    private Double sueldoBruto;
    private String tipoContrato;
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "empleado") //Relación unidireccional de 1 a n.
    @JsonIgnore
    private Set<registro> registros;

    public empleadoDTO toDTO(){
        empleadoDTO empleadoDTO = new empleadoDTO();
        empleadoDTO.setId(id);
        empleadoDTO.setRut(rut);
        empleadoDTO.setNombre(nombre);
        empleadoDTO.setApellidoPaterno(apellidoPaterno);
        empleadoDTO.setApellidoMaterno(apellidoMaterno);
        empleadoDTO.setTipoCargo(tipoCargo);
        empleadoDTO.setSueldoBruto(sueldoBruto);
        empleadoDTO.setTipoContrato(tipoContrato);
        empleadoDTO.setFechaIngreso(fechaIngreso);
        return empleadoDTO;
    }
}
//Notas
// .IDENTIFY Poca portabilidad pero eficiente para MySQL, Recomendación: .AUTO, ya que JPA elige la mejor opción dependiendo de la base de datos.
// .Date especifica que solo se utilizara el formato dd-mm-yyyy y no se incluye la hora.