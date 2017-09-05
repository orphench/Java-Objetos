package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.hbnutil.HibernateUtil;
import ar.org.centro8.curso.java.pojos.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTest {
    public static void main(String[] args) {
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(new Alumno("Veronica","Sayago",33,1));
        tx.commit();
        session.close();
        sf.close();
    }
}
