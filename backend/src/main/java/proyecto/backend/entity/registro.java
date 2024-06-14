package proyecto.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "registros")
public class registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaPago;
    private String RecibeBono;
    private double montoBono;
    private String porcentaje;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_empleado")
    @JsonIgnore
    private empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    @JsonIgnore
    private proyecto proyecto;

}
