package ar.org.centro8.curso.java.test;
  
import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.Cuenta;
import ar.org.centro8.curso.java.entities.Direccion;
import ar.org.centro8.curso.java.entities.Empleado;
import ar.org.centro8.curso.java.entities.Persona;

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
        
        //Continuar con Polimorfismo!!!!
        
        Persona p1 = new Empleado(1, 2000, "Micaela", "Suarez", dir2);
        Persona p2 = new Cliente(1, new Cuenta(30, "arg$"),
                    "Raul", "Mendez", dir2);
        
        System.out.println(p1);
        p1.saludar();
        System.out.println(p2);
        p2.saludar();
        
        Empleado e1 = (Empleado)p1;
        System.out.println(e1);
        
        System.out.println(e1.getClass());
        System.out.println(e1.getClass().getSuperclass());
        System.out.println(e1.getClass().getSuperclass().getSuperclass());
        System.out.println(e1.getClass().
                getSuperclass().
                getSuperclass().
                getSuperclass()
        );
        
        
    }
}
