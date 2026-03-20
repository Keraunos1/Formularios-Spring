package edu.pe.cibertec.wapformulariosspring.controller;

import edu.pe.cibertec.wapformulariosspring.model.LoginModel;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        model.addAttribute("MostrarMensaje", false);
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("loginModel") LoginModel loginModel
            , Model model) {
        if (loginModel.getUsuario().equals("lsalvatierra") &&
                loginModel.getPassword().equals("123")) {
            model.addAttribute("mensaje",
                    "Bienvenido: " + loginModel.getUsuario());
            return "home";
        }
        model.addAttribute("MostrarMensaje", true);
        model.addAttribute("mensaje",
                "Usuario y/o contraseña incorrecta!");
        return "login";
    }
}

