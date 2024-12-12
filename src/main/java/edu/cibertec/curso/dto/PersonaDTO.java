package edu.cibertec.curso.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {
    
    private int codigo;
    private String nombre;
    private String nroDoc;
    private Date fechaNacimiento;
    
}
