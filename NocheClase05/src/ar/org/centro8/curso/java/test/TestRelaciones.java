package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.ClienteMayorista;
import ar.org.centro8.curso.java.entities.ClienteMinorista;
import ar.org.centro8.curso.java.entities.Cuenta;

public class TestRelaciones {
    
    //psvm TAB
    public static void main(String[] args) {
        
        System.out.println("--cuenta1--");
        Cuenta cuenta1 = new Cuenta(1, "arg$");
        
        cuenta1.depositar(30000);
        cuenta1.depositar(20000);
        cuenta1.debitar(5000);
        System.out.println(cuenta1);
        
        System.out.println("--cliente minorista1--");
        ClienteMinorista cliMinorista1 = new ClienteMinorista(
                1,                          //nro Cliente
                "Ana",                      //Nombre
                "calle falsa 123",          //Direccion
                2                           //nro Cuenta
        );
        
        Cuenta cuenta = cliMinorista1.getCuenta();
        cuenta.depositar(20000);
        
        cliMinorista1.getCuenta().depositar(20000);
        cliMinorista1.getCuenta().debitar(10000);
        
        System.out.println(cliMinorista1);
        System.out.println(cliMinorista1.getCuenta());
        
        System.out.println("--cliente Mayorista1");
        ClienteMayorista cliMayorista1 = new ClienteMayorista(
                0,                          //cuenta
                "Todo Limpio",              //razon social
                "calle falsa 123"           //direccion
        );
        
        Cuenta[]cuentas = cliMayorista1.getCuentas();
        cuentas[0] = new Cuenta(10,"arg$");
        cuentas[1] = new Cuenta(11, "reals");
        cuentas[2] = new Cuenta(12, "dollar");
        
        cuentas[0].depositar(50000);
        cuentas[0].depositar(20000);
        cuentas[0].debitar(3000);
        
        cuentas[1].depositar(30000);
        
        cuentas[2].depositar(12000);
        
        System.out.println(cliMayorista1);
        System.out.println("-----------------");
        //for con operadores
        for (Cuenta c: cuentas ) System.out.println(c); 
            
        
   
    }
}
