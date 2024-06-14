package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.frontend.DTO.registroDTO;
import proyecto.frontend.service.IregistroService;

import java.util.List;

@Controller
@RequestMapping("/api/registros")
public class registroController{

    @Autowired
    private IregistroService registroService;

    @GetMapping("/Pagina")
    public String paginaregistros(Model model){
        List<registroDTO> registros = registroService.findAllREST();
        model.addAttribute("registros", registros);
        return "registros/registrosPrueba";
    }
}

