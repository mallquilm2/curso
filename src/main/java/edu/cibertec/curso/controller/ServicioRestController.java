package edu.cibertec.curso.controller;

import edu.cibertec.curso.dao.entity.CursoEntity;
import edu.cibertec.curso.dto.PersonaDTO;
import edu.cibertec.curso.service.CursoService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioRestController {
    
    @Autowired
    CursoService cursoService;
    
    //recurso dummy.
    @RequestMapping(value="/", produces = MediaType.APPLICATION_XML_VALUE)
    public PersonaDTO saludo(){
        PersonaDTO juan = new PersonaDTO(1, "JUan Perez", "10456798", new Date(Calendar.getInstance().getTimeInMillis()));
        return juan;
    }
    
    @GetMapping("/cursos")
    public List<CursoEntity> listarTodos(){
        return cursoService.listarTodos();
    }
    
    @GetMapping("/cursos/{id}")
    public CursoEntity obtenerUno(@PathVariable("id") int codigo){
        return cursoService.obtenerUno(codigo);
    }
    
    @PostMapping("/cursos")
    public void insertar(@RequestBody CursoEntity ce){
         cursoService.insertar(ce);
    }
    
    @PutMapping("/cursos/{id}")
    public void modificar(@RequestBody CursoEntity ce, 
            @PathVariable("id") int codigo){
        ce.setIdCurso(codigo);
        cursoService.modificar(ce);
    }
    
    @DeleteMapping("/cursos/{id}")
    public void eliminar(@PathVariable("id") int codigo){
        cursoService.eliminar(codigo);
    }

}
