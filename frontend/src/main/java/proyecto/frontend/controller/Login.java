package proyecto.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class Login {

        @GetMapping("/Login")
        public String showLoginForm() {
            return "Login/Login"; // Devuelve la vista de login
        }

        @PostMapping("/authenticate")
        public String authenticate(@RequestParam String username, @RequestParam String password) {
            // Verificar las credenciales (esto es solo un ejemplo, no debe hacerse así en producción)
            if ("USER".equals(username) && "1234".equals(password)) {
                return "redirect:/api/home"; // Redirige a la página de inicio si las credenciales son correctas
            } else {
                return "Login/Login"; // Vuelve a mostrar el formulario de login con un mensaje de error
            }
        }
    }
