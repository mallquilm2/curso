
package edu.cibertec.curso.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyCustomError {
    
    private String status;
    private String error;
    private String mensagge;
    
}
