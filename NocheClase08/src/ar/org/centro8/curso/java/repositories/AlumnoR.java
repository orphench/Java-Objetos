package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AlumnoR {
    private Connection con;
    //private Alumno alumno;

    public AlumnoR(Connection con) {
        this.con = con;
    }
    
    /*public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }*/
    
    public boolean save(Alumno alumno){
        //this.alumno = alumno;
        try{
            PreparedStatement ps = con.prepareStatement(
                    "insert into alumnos (nombre, apellido, edad, curso) "
                    +"values (?,?,?,?)"
                    ,PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getCurso());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) alumno.setId(rs.getInt(1)); 
                
            return true;
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        
    }

    public Alumno getById(int id){        
        //this.alumno = null;
        Alumno alumno = null;
        String query = "Select * from alumnos where id ="+id;
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            if(rs.next()){
                alumno = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("curso")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return alumno;
    }
    
    public boolean remove(Alumno alumno){
        if (alumno != null) {
            String query = "delete from alumnos where id="+alumno.getId();
            try {
                con.createStatement().execute(query);
                alumno = null;
                return true;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public List<Alumno>getAll(){
        return getByFiltro("1=1");
    }
    
    public List<Alumno>getByFiltro(String filtro){
        List<Alumno> lista = new ArrayList();
        String query = "select * from alumnos where "+filtro;
        try {
            ResultSet rs = con.createStatement().executeQuery(query);
            while(rs.next()){
                lista.add(
                        new Alumno(
                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getInt("edad"),
                                rs.getInt("curso")
                        )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public boolean update(Alumno alumno){
        if (alumno != null) {
            String query = "update alumnos set nombre=?, apellido=?, edad=?, curso=? "
                    + "where id=?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, alumno.getNombre());
                ps.setString(2, alumno.getApellido());
                ps.setInt(3, alumno.getEdad());
                ps.setInt(4, alumno.getCurso());
                ps.setInt(5, alumno.getId());
                return ps.execute();
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        else{
            return false;
        }
    }
}
