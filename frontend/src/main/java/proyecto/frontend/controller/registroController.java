package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.frontend.DTO.empleadoDTO;
import proyecto.frontend.DTO.proyectoDTO;
import proyecto.frontend.DTO.registroDTO;
import proyecto.frontend.service.IregistroService;
import proyecto.frontend.service.IempleadoService;
import proyecto.frontend.service.IproyectoService;

import java.util.List;

@Controller
@RequestMapping("/api/registros")
public class registroController{

    @Autowired
    private IregistroService registroService;

    @Autowired
    private IempleadoService empleadoService;

    @Autowired
    private IproyectoService proyectoService;

    @GetMapping("/Pagina")
    public String paginaregistros(Model model){
        List<registroDTO> registros = registroService.findAllREST();
        model.addAttribute("registros", registros);
        registroDTO registro = new registroDTO();
        registro.setRecibeBono("");
        registro.setPorcentaje("");
        registro.setMontoBono(0.0);
        registro.setEstado("");
        registro.setFechaPago("");
        registro.setSueldoConBono(0.0);

        empleadoDTO empleado = empleadoService.findByIdREST(3L);
        proyectoDTO proyecto = proyectoService.findByIdREST(7L);
        registro.setEmpleado(empleado);
        registro.setProyecto(proyecto);

        registroDTO RegistroAMostrar = registroService.CalcularBonoREST(registro);
        model.addAttribute("Bonos",RegistroAMostrar);

        return "registros/registrosPrueba";
    }
}

