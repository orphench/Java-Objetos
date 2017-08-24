package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import java.sql.Connection;

public class TestR {
    public static void main(String[] args) throws Exception{
        Connection con = Connector.getConnection();
        Alumno a = new Alumno("Luis", "Vallejos", 25, 1);
        AlumnoR ar = new AlumnoR(con);
        ar.save(a);
        System.out.println(ar.getAlumno());
        con.close();
        
        new AlumnoR(Connector.getConnection())
                .save(new Alumno("Daniela", "Lopez", 25, 2));
        
        ar = new AlumnoR(Connector.getConnection());
        ar.save(new Alumno("Lucas", "Gomez",23,1));
        System.out.println(ar.getAlumno());
        
        System.out.println(new AlumnoR(Connector.getConnection()).getById(3));
        System.out.println(new AlumnoR(Connector.getConnection()).getById(300));
    }
}
