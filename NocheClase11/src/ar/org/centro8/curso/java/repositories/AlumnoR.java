package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.pojos.Alumnos;
import org.hibernate.SessionFactory;

public class AlumnoR extends GenericR<Alumnos,Integer>{

    public AlumnoR(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
}
