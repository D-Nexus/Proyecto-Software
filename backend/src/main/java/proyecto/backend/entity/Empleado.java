package proyecto.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-incremental
    private Long id; //PK

    //Columnas
    private String rut;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String tipoCargo;
    private Double sueldoBruto;
    private String tipoContrato;
    private LocalDate fechaIngreso;

    /*@Temporal(TemporalType.DATE) //Anotación para la utilización de las fechas
    private Date fechaIngreso; */

    @OneToMany(mappedBy = "empleado") //Relación unidirecional de 1 a n.
    @JsonIgnore
    private Set<Registro> registros;
}

//Notas
// .IDENTIFY Poca portabilidad pero eficiente para MySQL, Recomendación: .AUTO, ya que JPA elige la mejor opción dependiendo de la base de datos.
// .Date especifica que solo se utilizara el formato dd-mm-yyyy y no se incluira la hora.

