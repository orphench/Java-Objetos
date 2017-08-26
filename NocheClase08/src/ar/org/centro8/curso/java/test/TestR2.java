package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class TestR2 {
    public static void main(String[] args) {
        Connection con = Connector.getConnection();
        AlumnoR ar = new AlumnoR(con);
        ar.remove(ar.getById(2));
        
        ar.getAll().forEach(System.out::println);
        System.out.println("-------------------------------------");
        
        ar.getByFiltro("nombre='Ana'").forEach(System.out::println);
        System.out.println("-------------------------------------");
        
        ar.getByFiltro("apellido like '%r%'").forEach(System.out::println);
        
        Alumno a = ar.getById(3);
        if(a!=null){
           a.setNombre("Romina");
           a.setApellido("Aguilera"); 
        }
        
        ar.update(a);
        
        ar.getAll().forEach(System.out::println);
        System.out.println("--------------------------------------");
        
    }
}
