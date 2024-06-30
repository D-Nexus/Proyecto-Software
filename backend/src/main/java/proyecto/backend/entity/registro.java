package proyecto.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.backend.DTO.registroDTO;

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

    private String RecibeBono;
    private String porcentaje;
    private double montoBono;
    private LocalDate fechaPago;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_empleado")
    @JsonIgnore
    private empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    @JsonIgnore
    private proyecto proyecto;

    public registroDTO toDTO(){
        registroDTO RegistroDTO = new registroDTO();
        RegistroDTO.setId(this.getId());
        RegistroDTO.setRecibeBono(this.getRecibeBono());
        RegistroDTO.setPorcentaje(this.getPorcentaje());
        RegistroDTO.setMontoBono(this.getMontoBono());
        RegistroDTO.setEstado(this.getEstado());
        RegistroDTO.setFechaPago(this.getFechaPago());
        RegistroDTO.setEmpleado(this.empleado.toDTO());
        RegistroDTO.setProyecto(this.proyecto.toDTO());
        return RegistroDTO;
    }
}
