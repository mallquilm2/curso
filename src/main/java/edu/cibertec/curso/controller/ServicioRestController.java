package edu.cibertec.curso.controller;

import edu.cibertec.curso.dto.PersonaDTO;
import java.util.Calendar;
import java.util.Date;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioRestController {
    
    @RequestMapping(value="/", produces = MediaType.APPLICATION_XML_VALUE)
    public PersonaDTO saludo(){
        PersonaDTO juan = new PersonaDTO(1, "JUan Perez", "10456798", new Date(Calendar.getInstance().getTimeInMillis()));
        return juan;
    }

}
