package ar.org.centro8.curso.java.repositories;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class GenericR <E, PK extends Serializable>{
    private SessionFactory sessionFactory;

    public GenericR(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public PK save(E e){
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        Serializable id=null;
        try {
            id=session.save(e);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        
        session.close();
        return (PK)id;
    }
    
    public void update(E e){
        Session session = sessionFactory.openSession();  
        Transaction tx = session.beginTransaction();
        try {
            session.update(e);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        session.close();
    }
    
    public void delete(E e){
        Session session = sessionFactory.openSession();  
        Transaction tx = session.beginTransaction();
        try {
            session.delete(e);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        }
        session.close();
    }
    
    private Class getType(){
        Class clazz = this.getClass();
        ParameterizedType prt=(ParameterizedType)clazz.getGenericSuperclass();
        Type[] types = prt.getActualTypeArguments();
        return (Class)types[0];
    }
    
    public E get(PK id){
        Session session = sessionFactory.openSession();
        E e = (E)session.get(getType(), id);
        session.close();
        return e;
    }
    
    public List<E>getAll(){
        Session session=sessionFactory.openSession();
        Query query = session.createQuery("from "+getType().getName());
        List<E> lista = query.list();
        session.close();
        return lista;
    }
    
    public List<E>getByFiltro(String filtro){
        Session session=sessionFactory.openSession();
        Query query = session.createQuery("from "+getType().getName()+" where "+filtro);
        List<E> lista = query.list();
        session.close();
        return lista;
    }
}
