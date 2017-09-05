package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.pojos.Alumno;
import java.util.List;
import org.hibernate.SessionFactory;

public class AlumnoR extends GenericR<Alumno,Integer>{

    public AlumnoR(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public Alumno getById(Integer id){
        return get(id);
    }
    
    public List<Alumno> getByNombre(String nombre){
        return getByFiltro("nombre='"+nombre+"'");
    }
    
    public List<Alumno> getByApellido(String apellido){
        return getByFiltro("apellido='"+apellido+"'");
    }
    
    public List<Alumno> getByEdad(int edad){
        return getByFiltro("edad='"+edad+"'");
    }
    
    public List<Alumno> getByCurso(int idCurso){
        return getByFiltro("curso='"+idCurso+"'");
    }
}
