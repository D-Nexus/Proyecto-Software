package proyecto.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.backend.DTO.empleadoDTO;
import proyecto.backend.DTO.proyectoDTO;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "proyectos")
public class proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-incremental
    private Long id; //PK

    //Columnas
    private String nombreProyecto;
    private String comuna;
    private Integer cantEmpleados;
    private LocalDate fechaInicio;
    private LocalDate fechaTerminoPactada;
    private LocalDate fechaTerminoReal;
    private String estado;


    @OneToMany(mappedBy = "proyecto") //Relación unidireccional de 1 a n.
    @JsonIgnore
    private Set<registro> registros;

    public proyectoDTO toDTO(){
        proyectoDTO proyectoDTO = new proyectoDTO();
        proyectoDTO.setId(id);
        proyectoDTO.setNombreProyecto(nombreProyecto);
        proyectoDTO.setComuna(comuna);
        proyectoDTO.setCantEmpleados(cantEmpleados);
        proyectoDTO.setFechaInicio(fechaInicio);
        proyectoDTO.setFechaTerminoPactada(fechaTerminoPactada);
        proyectoDTO.setFechaTerminoReal(fechaTerminoReal);
        proyectoDTO.setEstado(estado);
        return proyectoDTO;
    }
}
