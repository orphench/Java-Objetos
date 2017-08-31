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
        //alumnoR.save(new alumnos("Jose","Garcia",24,1));
        
        System.out.println("------------ALUMNOS GET ALL--------------------");
        
        //alumnoR.getAll("alumnos").forEach(System.out::println);
        
        System.out.println("------------GET BY FILTRO--------------------------");
        //alumnoR.getByFiltro("nombre='Juan'","alumnos").forEach(System.out::println);
        
        System.out.println("------------GET BY ID-----------------------------");
        //System.out.println(alumnoR.getById(32, "alumnos"));
        
        System.out.println("------------CURSOS--------------------");
        
        GenericR<cursos> cursoR = new GenericR(con);
        //cursoR.save(new cursos("php","Gomez","Martes","Noche"));
        
        System.out.println("------------CURSOS GET ALL---------------");
        
        //cursoR.getAll("cursos").forEach(System.out::println);
        
        System.out.println("----------REMOVE-------------------------");
        
        //alumnoR.remove(alumnoR.getById(34, "alumnos"));
        
        System.out.println("---------UPDATE---------------------------");
        
        alumnos alumno = alumnoR.getById(3, "alumnos");
        if(alumno!=null){
           alumno.setNombre("Veronica");
           alumno.setApellido("Molina");
           alumnoR.update(alumno); 
        }
               
        alumnoR.getAll("alumnos").forEach(System.out::println);
        
        
    }
}
