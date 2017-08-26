package ar.org.centro8.curso.java.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    //private static String driver = "com.mysql.jdbc.Driver";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String vendor = "mysql";
    //private static String server = "localhost";
    private static String server = "172.16.10.250";
    private static String port = "3306";
    private static String bd = "colegio";
    private static String user = "root";
    private static String pass = "";
    //private static String url = "jdbc:"+vendor+"://"+server+":"+port+"/"+bd;
    private static String url = "jdbc:"+vendor+"://"+server+":"+port+"/"+bd+"?serverTimezone=UTC";
    private static Connection con = null;
    
    private Connector(){}
        
    public static Connection getConnection(){
        if (con == null){
            try {
                Class.forName(driver);
                return DriverManager.getConnection(url,user,pass);
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }else{
            return con;
        } 
        
    }
    
    
}
