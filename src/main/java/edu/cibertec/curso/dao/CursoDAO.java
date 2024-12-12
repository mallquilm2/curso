
package edu.cibertec.curso.dao;

import edu.cibertec.curso.dao.entity.CursoEntity;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CursoDAO extends JpaRepository<CursoEntity, Integer>{
    
}
