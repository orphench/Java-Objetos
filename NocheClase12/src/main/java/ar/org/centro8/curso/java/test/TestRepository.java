package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.hbnutil.HibernateUtil;
import ar.org.centro8.curso.java.pojos.Alumno;
import ar.org.centro8.curso.java.pojos.Curso;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import ar.org.centro8.curso.java.repositories.CursoR;
import org.hibernate.SessionFactory;


public class TestRepository {
    public static void main(String[] args) {
       SessionFactory sf = HibernateUtil.getSessionFactory();
       CursoR cr = new CursoR(sf);
       AlumnoR ar = new AlumnoR(sf);
       
       //cr.save(new Curso("Java","Rios","Jueves","Noche"));
       //ar.save(new Alumno("Rodrigo","Vaca",33,2));
       
       //cr.getAll().forEach(System.out::println);
       
       cr.getByProfesor("Rios").forEach(System.out::println);
       System.out.println("--------------------------------");
       ar.getByCurso(2).forEach(System.out::println);
       System.out.println("--------------------------------");
       cr.getByTitulo("HTML").forEach(System.out::println);
       System.out.println("--------------------------------");
       cr.getByTurno("noche").forEach(System.out::println);
       sf.close();
    } 
}
