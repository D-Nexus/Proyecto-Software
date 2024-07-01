package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class menuController {

    //http://localhost:8081/api/home
    @GetMapping("/home")
    public String home() {
        return "menu/Menu_ingco";
    }
}
