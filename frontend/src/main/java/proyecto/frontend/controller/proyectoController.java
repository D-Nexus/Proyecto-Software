package proyecto.frontend.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.frontend.DTO.empleadoDTO;
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
        return "proyectos/ProyectosIndex";
    }

    @GetMapping("/Formulario")
    public String agregarREST(Model model) {
        proyectoDTO ProyectoDTO = new proyectoDTO();
        model.addAttribute("proyectoCreate", ProyectoDTO);
        return "proyectos/FormularioCreate";
    }

    @PostMapping("/CreateProyecto")
    public String CreateREST(@ModelAttribute proyectoDTO proyecto,Model model) {
        proyectoService.saveREST(proyecto);
        return "redirect:/api/proyectos/Pagina";
    }

    @GetMapping("editar/{id}")
    public String editarREST(@PathVariable Long id, Model model) throws Exception {
        proyectoDTO proyecto = proyectoService.findByIdREST(id);
        model.addAttribute("proyectoEditar", proyecto);
        return "proyectos/FormularioUpdate";
    }

    @PostMapping(value = "/Update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProyecto(@ModelAttribute proyectoDTO proyecto) {
        proyectoDTO proyectoDTO = proyectoService.updateREST(proyecto.getId(), proyecto);
        return "redirect:/api/proyectos/Pagina";
    }

    @GetMapping("Delete/{id}")
    public String deleteREST(@PathVariable Long id, Model model) throws Exception {
        proyectoService.deleteREST(id);
        return "redirect:/api/proyectos/Pagina";
    }
}

