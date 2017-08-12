package ar.org.centro8.curso.java.test;
  
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.Cuenta;
import ar.org.centro8.curso.java.entities.Direccion;
import ar.org.centro8.curso.java.entities.Empleado;

public class TestHerencia {
    public static void main(String[] args) {
        System.out.println("--dir1--");
        Direccion dir1 = new Direccion("Larrea", "2485", "4", "e");
        System.out.println(dir1);
        
        System.out.println("--dir2--");
        Direccion dir2 = new Direccion("Maipu", "1440", null, null, "Olivos");
        System.out.println(dir2);
        
        System.out.println("--empleado1--");
        Empleado empleado1 = new Empleado(1, 25000, "Javier", "Gutierrez", dir1);
        empleado1.saludar();
        System.out.println(empleado1);
        
        System.out.println("--cliente1--");
        Cliente cli1 = new  Cliente(
                01,                             //nro cliente
                new Cuenta(20, "arg$"),         //cuenta
                "Tania",                        //nombre
                "Mendez",                       //apellido
                dir2                            //direccion
        );
        
        cli1.getCuenta().depositar(150000);
        cli1.getCuenta().debitar(5000);
        cli1.saludar();
        System.out.println(cli1);
        System.out.println(cli1.getCuenta());
    }
}
