package ar.org.centro8.java.curso.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.alumnos;
import ar.org.centro8.curso.java.entities.cursos;
import ar.org.centro8.curso.java.repositories.GenericR;
import java.sql.Connection;

public class TestGenericR {
    public static void main(String[] args) {
        Connection con = Connector.getConnection();
        GenericR<alumnos> alumnoR = new GenericR(con);
        alumnoR.save(new alumnos("Jose","Garcia",24,1));
        
        GenericR<cursos> cursoR = new GenericR(con);
        cursoR.save(new cursos("php","Gomez","Martes","Noche"));
    }
}
