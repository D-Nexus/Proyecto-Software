package proyecto.frontend.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.frontend.DTO.empleadoDTO;
import proyecto.frontend.service.IempleadoService;

import java.util.List;

@Controller
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "http://localhost:8081")
public class empleadoController{

    @Autowired
    private IempleadoService empleadoService;

    @GetMapping("/PaginaEmpleados")
    public String home() {
        return "empleados/Empleados";
    }

    @GetMapping("/Pagina")
    public String paginaEmpleados(Model model){

        List<empleadoDTO> empleados = empleadoService.findAllREST(); // Creacion de lista para usar el servicio de buscar a todos los empleados.
        model.addAttribute("empleados", empleados); // creacion del model para injectar en el HTML, IMPORTANTE= modificar <tr th:each="Nombre del objeto(en este caso seria: empleado ): ${Nombre Del Atributo(en este caso seria: empleados )}">, en el HTML de empleado

        /*empleadoDTO empleados1 = empleadoService.findByIdREST(2L); // Creacion de objeto para usar el servicio de buscar por id del empleado.
        model.addAttribute("empleados1", empleados1); // creacion del model para injectar en el HTML, IMPORTANTE= modificar <tr th:each="Nombre del objeto(en este caso seria: empleado ): ${Nombre Del Atributo(en este caso seria: "empleados1 )}">, en el HTML de empleado

        empleadoService.deleteREST(11L); // Prueba de eliminacion de objeto mediante el frontend, estado: exitosa.

        empleadoDTO empleadoAUpdatear = new empleadoDTO(); //Creacion de objeto para usar el servicio de update mediante el id de un empleado.
        empleadoAUpdatear.setNombre("PRUEBA CAMBIO"); // seteamos el nombre a updatear
        empleadoService.updateREST(12L,empleadoAUpdatear); // usamos el servicio para updatear, se necesita el id y el objeto modificado.
        */
        return "empleados/EmpleadosIndex";
    }

    @GetMapping("/Formulario")
    public String agregarREST(Model model) {
        empleadoDTO EmpleadoDTO = new empleadoDTO();
        model.addAttribute("empleadoCreate", EmpleadoDTO);
        return "empleados/FormularioCreate";
    }

    @PostMapping("/CreateEmpleado")
    public String CreateREST(@ModelAttribute empleadoDTO empleado,Model model) {
        empleadoService.saveREST(empleado);
        return "redirect:/api/empleados/Pagina";
    }

    @GetMapping("editar/{id}")
    public String editarREST(@PathVariable Long id, Model model) throws Exception {
        empleadoDTO empleado = empleadoService.findByIdREST(id);
        model.addAttribute("empleadoEditar", empleado);
        return "empleados/FormularioUpdate";
    }

    /*
    @PostMapping("Update")
    public String saveREST(@RequestBody empleadoDTO EmpleadoDTO, Model model) throws Exception {
        empleadoDTO empleadoDTO = empleadoService.updateREST(EmpleadoDTO.getId(), EmpleadoDTO);
        return "redirect:/api/empleados/Pagina";
    }*/

    @PostMapping(value = "/Update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateEmpleado(@ModelAttribute empleadoDTO empleado) {
        empleadoDTO empleadoDTO = empleadoService.updateREST(empleado.getId(), empleado);
        return "redirect:/api/empleados/Pagina";
    }
    @GetMapping("Delete/{id}")
    public String deleteREST(@PathVariable Long id, Model model) throws Exception {
        empleadoService.deleteREST(id);
        return "redirect:/api/empleados/Pagina";
    }



}
