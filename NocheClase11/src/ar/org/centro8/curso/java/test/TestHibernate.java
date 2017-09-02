package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.hbutil.HibernateUtil;
import ar.org.centro8.curso.java.pojos.Alumnos;
import ar.org.centro8.curso.java.pojos.Cursos;
import ar.org.centro8.curso.java.repositories.AlumnoR;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        //insert
        Transaction tx = session.beginTransaction();
        //session.save(new Alumnos("Carolina","Torres",18,2));
        //session.save(new Cursos("C#.net","Gago","Lunes","Noche"));
        tx.commit();
        
        //select hql Hibernate Query Languaje              
        tx = session.beginTransaction();
        try {
            session.delete((Alumnos)session.createQuery("from Alumnos where id=40").list().get(0));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        
        //Update
        tx = session.beginTransaction();
        try {
            Alumnos alumno = (Alumnos)session.createQuery("from Alumnos where id=25").list().get(0);
            alumno.setNombre("Mariel");
            alumno.setApellido("Perro Loco");
            session.update(alumno);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        
        Alumnos alumno = (Alumnos)session.createQuery("from Alumnos where id=28").list().get(0);
        alumno.setNombre("Gatita");
        alumno.setApellido("Gata Meown");
        
        Alumnos alumno2 = (Alumnos)session.get(Alumnos.class, 29);
        
        session.createQuery("From Alumnos").list().forEach(System.out::println);
                session.close();
        
        AlumnoR ar=new AlumnoR(sf);
        ar.save(new Alumnos("Micaela","Lorenzo",23,2));
        ar.update(alumno);
        ar.delete(alumno2);
        
         Alumnos alumno3 = ar.get(38);
         System.out.println(alumno3);
         System.out.println(ar.get(39));
         
         ar.getAll().forEach(System.out::println);
         System.out.println("------------------");
         ar.getByFiltro("apellido like 'to%'").forEach(System.out::println);

        sf.close();
    }
}
