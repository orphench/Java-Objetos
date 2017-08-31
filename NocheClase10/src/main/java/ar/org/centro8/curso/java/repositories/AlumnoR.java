package ar.org.centro8.curso.java.repositories;

import java.sql.Connection;
import java.util.List;

public class AlumnoR<E> extends GenericR<E>{

    public AlumnoR(Connection conn) {
        super(conn);
    }
    
    public List<E> getByApellido(String apellido){
        return getByFiltro("apellido='"+apellido+"'","alumnos");
    }
}
