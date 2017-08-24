package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.connectors.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection con = Connector.getConnection();
        Statement stm = con.createStatement();
        String query = "insert into alumnos (nombre, apellido, edad, curso)" 
                + "values ('Ana', 'Garcia', 24, 1)";
        stm.execute(query);
        stm.close();
        con.close();
        
        Connector.getConnection().createStatement().execute(
            "insert into alumnos (nombre, apellido, edad, curso) "
            + "values ('Jose', 'Mendez', 21, 2)"
        );
        
        int x = Connector.getConnection().createStatement().executeUpdate(
                "insert into alumnos (nombre, apellido, edad, curso) "
                + "values ('Juan', 'Sosa', 27, 3)");
        
        System.out.println("Se inserto "+x+" registros.");
        
        //Select
        ResultSet rs = Connector.getConnection().createStatement().executeQuery(
                "Select * from alumnos"
        );
        
        while(rs.next()){
            System.out.println(
                    rs.getInt("id")+" "+
                    rs.getString("nombre")+" "+
                    rs.getString("apellido")+" "+
                    rs.getInt("edad")+" "+
                    rs.getInt("curso")
            );
        }
    }   
}
