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
@RequestMapping("/api/pagos")
public class pagosController {
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
        return "pagos/PagosIndex";
    }
}
