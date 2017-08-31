package ar.org.centro8.curso.java.repositories;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
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

    public E getById(int id, String type) {
        List<E> lista = getByFiltro("id=" + id, type);
        return (lista.size() > 0) ? lista.get(0) : null;
    }

    public List<E> getAll(String type) {
        return getByFiltro("1=1", type);
    }

    public List<E> getByFiltro(String filtro, String type) {
        //una linea comentada
        List<E> lista = new ArrayList();
        String query = "select * from " + type + " where " + filtro;
        try {
            ResultSet rs = conn.createStatement().executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                E e = (E) Class.forName("ar.org.centro8.curso.java.entities." + type).newInstance();
                for (int a = 1; a < rsmd.getColumnCount(); a++) {
                    String field = rsmd.getColumnName(a);
                    String method = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
                    System.out.println(method);
                    if (rsmd.getColumnTypeName(a).equals("INT")) {
                        e.getClass().getMethod(method, int.class).invoke(e, rs.getInt(a));
                    }
                    if (rsmd.getColumnTypeName(a).equals("VARCHAR")) {
                        e.getClass().getMethod(method, String.class).invoke(e, rs.getString(a));
                    }
                }
                lista.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return lista;
    }
    
    public boolean remove(E e){
        if(e==null) return false;
        try {
            String table = e.getClass().getSimpleName();
            String query = "delete from "+table+" where id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setObject(1, e.getClass().getMethod("getId", null).invoke(e));
            return ps.execute();
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
                
    }
    
    public boolean update(E e){
        if(e==null) return false;
        String table = e.getClass().getSimpleName();
        String query = "update "+table+" set ";
        Field[] fields = e.getClass().getDeclaredFields();
        for(int a=1; a<fields.length; a++){
            if (a!=1) query+=",";
            query+=fields[a].getName()+"=?";           
        }
        query+=" where id=?";
        System.out.println(query);
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            for(int a=1; a<fields.length; a++){
                String name=fields[a].getName();
                String method = "get"+name.substring(0,1).toUpperCase()+name.substring(1);
                ps.setObject(a, e.getClass().getMethod(method, null).invoke(e));               
            }
            ps.setObject(fields.length, e.getClass().getMethod("getId",null).invoke(e));
            return ps.execute();
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
