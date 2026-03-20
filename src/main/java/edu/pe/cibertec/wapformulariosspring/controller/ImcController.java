package edu.pe.cibertec.wapformulariosspring.controller;

import edu.pe.cibertec.wapformulariosspring.model.ImcModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ImcController {
    @GetMapping("/imc")
    public String inicioImc(Model model){
        model.addAttribute("imcModel", new ImcModel());
        model.addAttribute("mostrarMensaje", false);
        return "imc";
    }
    @PostMapping("/imc")
    public String calcularImc(@ModelAttribute("imcModel") ImcModel imcModel,
                              Model model){
        double tallam = imcModel.getTalla() / 100;
        double valorImc = imcModel.getPeso() / (tallam * tallam);
        String diagnostico = "";
        if( valorImc <= 18.5){
             diagnostico = "Por debajo del peso";
        }
        else if( valorImc <= 25){
             diagnostico = "Con peso normal";
        }
        else if( valorImc <= 30){
             diagnostico = "Con sobrepeso";
        }
        else if( valorImc <= 35){
             diagnostico = "Con obesidad media";
        }
        else {
             diagnostico = "Con obesidad mórbida";
        }
        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "Su valor IMC es: "
        + String.format("%.2f", valorImc) + ", usted se encuentra " + diagnostico);
        return "imc";

    }
}
