package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class menuController {
    //http://localhost:8081/api/home
    @RequestMapping("/api/home")
    public String home() {
        return "menu/Menu_ingco";
    }
}
