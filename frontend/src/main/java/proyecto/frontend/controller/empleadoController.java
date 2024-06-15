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

        List<empleadoDTO> empleados = empleadoService.findAllREST(); // Creacion de lista para usar el servicio de buscar a todos los empleados.
        model.addAttribute("empleados", empleados); // creacion del model para injectar en el HTML, IMPORTANTE= modificar <tr th:each="Nombre del objeto(en este caso seria: empleado ): ${Nombre Del Atributo(en este caso seria: empleados )}">, en el HTML de empleado

        empleadoDTO empleados1 = empleadoService.findByIdREST(2L); // Creacion de objeto para usar el servicio de buscar por id del empleado.
        model.addAttribute("empleados1", empleados1); // creacion del model para injectar en el HTML, IMPORTANTE= modificar <tr th:each="Nombre del objeto(en este caso seria: empleado ): ${Nombre Del Atributo(en este caso seria: "empleados1 )}">, en el HTML de empleado

        empleadoService.deleteREST(11L); // Prueba de eliminacion de objeto mediante el frontend, estado: exitosa.

        empleadoDTO empleadoAUpdatear = new empleadoDTO(); //Creacion de objeto para usar el servicio de update mediante el id de un empleado.
        empleadoAUpdatear.setNombre("PRUEBA CAMBIO"); // seteamos el nombre a updatear
        empleadoService.updateREST(12L,empleadoAUpdatear); // usamos el servicio para updatear, se necesita el id y el objeto modificado.

        return "empleados/empleadosPrueba";
    }
}
