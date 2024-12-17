package edu.cibertec.curso.controller;

import edu.cibertec.curso.dao.entity.CursoEntity;
import edu.cibertec.curso.dto.PersonaDTO;
import edu.cibertec.curso.service.CursoService;
import edu.cibertec.curso.util.MyCustomError;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ServicioRestController {
    
    @Autowired
    CursoService cursoService;
    
    @ExceptionHandler(Exception.class)
    private ResponseEntity manejarExepciones(){
        MyCustomError err = new MyCustomError(HttpStatus.CONFLICT.toString(), "Problema interno", "Ha ocurrido un error en la aplicación. Verifique su Request!");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
    
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
        try {
            return cursoService.obtenerUno(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no localizado",e);
        }
    }
    
    @PostMapping("/cursos")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertar(@RequestBody CursoEntity ce){
        try {
            cursoService.insertar(ce);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Curso no pudo ser procesado",e);
        }
         
    }
    
    @PutMapping("/cursos/{id}")
    public void modificar(@RequestBody CursoEntity ce, 
            @PathVariable("id") int codigo){
        ce.setIdCurso(codigo);
        cursoService.modificar(ce);
    }
    
    @DeleteMapping("/cursos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id") int codigo){
        cursoService.eliminar(codigo);
    }

}
