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
@Table(name= "proyectos")
public class proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProyecto;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminoPactada;
    private LocalDate fechaTerminoReal;
    private String estado;
    private String comuna;
    private Integer cantEmpleados;


    @OneToMany(mappedBy = "proyecto")
    @JsonIgnore
    private Set<registro> registros;

}
