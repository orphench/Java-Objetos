package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.pojos.Curso;
import java.util.List;
import org.hibernate.SessionFactory;

public class CursoR extends GenericR<Curso, Integer>{
    
    public CursoR(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public Curso getById(Integer id){
        return get(id);
    }
    
    public List<Curso> getByTitulo(String titulo){
        return getByFiltro("titulo='"+titulo+"'");
    }
    
    public List<Curso> getByProfesor(String profesor){
        return getByFiltro("profesor='"+profesor+"'");
    }
    
    public List<Curso> getByDia(String dia){
        return getByFiltro("dia='"+dia+"'");     
    }
    
    public List<Curso> getByTurno(String turno){
        return getByFiltro("turno='"+turno+"'");
    }
}
