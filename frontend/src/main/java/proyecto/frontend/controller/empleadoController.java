package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.frontend.DTO.empleadoDTO;
import proyecto.frontend.service.IempleadoService;

import java.util.List;

@Controller
@RequestMapping("/api/empleados")
public class empleadoController{

    @Autowired
    private IempleadoService empleadoService;

    @GetMapping("/Pagina")
    public String paginaEmpleados(Model model){
        List<empleadoDTO> empleados = empleadoService.findAllREST();
        model.addAttribute("empleados", empleados);
        return "empleados/empleadosPrueba";
    }
}
