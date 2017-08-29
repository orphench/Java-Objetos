package ar.org.centro8.curso.java.repositories;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class GenericR<E> {

    private Connection conn;

    public GenericR(Connection conn) {
        this.conn = conn;
    }

    public boolean save(E e) {
        String table = e.getClass().getSimpleName();
        String query = "insert into " + table + " (";
        Field[] fields = e.getClass().getDeclaredFields();
        for (int a = 0; a < fields.length; a++) {
            if (a != 0) {
                query += ",";
            }
            query += fields[a].getName();
        }
        query += ") values (";
        for (int a = 0; a < fields.length; a++) {
            if (a != 0) {
                query += ",";
            }
            query += "?";
        }
        query += ")";
        System.out.println(query);
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println(conn);
            for (int a = 0; a < fields.length; a++) {
                String field = fields[a].getName();
                String method = "get" + field.substring(0, 1).toUpperCase()
                        + field.substring(1, field.length());
                System.out.println(method);
                if (a == 0) {
                    ps.setObject(a + 1, null);
                } else {
                    ps.setObject(a + 1, e.getClass().getMethod(method, null).invoke(e));
                }
            }
            return ps.execute();
        } catch (Exception x) {
            System.out.println(x);
            return false;
        }
    }    
        
    public E getById(int id){
        List<E> lista = getByFiltro("id="+id);
        return (lista.size()>0)?lista.get(0):null;
    }
    
    public List<E> getAll(){
        return getByFiltro("1=1");
    }
    
    public List<E>getByFiltro(String filtro){
        
    }
}


