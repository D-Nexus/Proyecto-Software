package proyecto.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-incremental
    private Long id; //PK
    //Columnas
    private String nombreProyecto;
    private String comuna;
    private Integer cantEmpleados;
    private String estado;


    @Temporal(TemporalType.DATE) //Anotación para la utilización de las fechas
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaTerminoPactada;

    @Temporal(TemporalType.DATE)
    private Date fechaTerminoReal;

    @OneToMany(mappedBy = "proyecto") //Relación unidirecional de 1 a n.
    @JsonIgnore
    private Set<Registro> registros;

}
//Notas
// .IDENTIFY Poca portabilidad pero eficiente para MySQL, Recomendación: .AUTO, ya que JPA elige la mejor opción dependiendo de la base de datos.
// .Date especifica que solo se utilizara el formato dd-mm-yyyy y no se incluira la hora.