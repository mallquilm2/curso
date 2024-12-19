
package edu.cibertec.curso.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curso")
@NamedQuery(name = "CursoEntity.abiertoIncompleto", query="SELECT c FROM CursoEntity c WHERE c.alumnosMin > c.alumnosAct AND c.estado = 1")
public class CursoEntity extends RepresentationModel<CursoEntity>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    private String nomCurso;
    private Date fechaInicio;
    private Integer alumnosMin;
    private Integer alumnosAct;
    private Integer estado;
    
}
