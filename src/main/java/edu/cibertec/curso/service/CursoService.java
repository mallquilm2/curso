
package edu.cibertec.curso.service;

import edu.cibertec.curso.dao.CursoDAO;
import edu.cibertec.curso.dao.entity.CursoEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    @Autowired
    CursoDAO cursoDAO;
    
    public List<CursoEntity> listarTodos(){
        return cursoDAO.findAll();
    }
    
    public CursoEntity obtenerUno(int codigo){
        return cursoDAO.findById(codigo).get();
    }
    
    public void insertar(CursoEntity ce){
        cursoDAO.save(ce);
    }
    
    public void modificar(CursoEntity ce){
        cursoDAO.save(ce);
    }
    
    public void eliminar(int codigo){
        cursoDAO.deleteById(codigo);
    }
    
}
