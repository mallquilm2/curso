package edu.cibertec.curso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioRestController {
    
    @RequestMapping("/")
    public String saludo(){
        return "Hola desde spring rest.";
    }

}
