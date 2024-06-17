package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.frontend.DTO.proyectoDTO;
import proyecto.frontend.service.IproyectoService;

import java.util.List;

@Controller
@RequestMapping("/api/proyectos")
public class proyectoController{

    @Autowired
    private IproyectoService proyectoService;

    //http://localhost:8081/api/proyectos/PaginaProyecto
    @GetMapping("/PaginaProyecto")
    public String home() {
        return "proyectos/Proyecto";
    }

    @GetMapping("/Pagina")
    public String paginaproyectos(Model model){
        List<proyectoDTO> proyectos = proyectoService.findAllREST();
        model.addAttribute("proyectos", proyectos);
        return "proyectos/proyectosPrueba";
    }
}

