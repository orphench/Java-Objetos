package ar.org.centro8.curso.java.entities;

public class Empleado extends Persona{
    private int legajo;
    private float sueldo;

    public Empleado(int legajo, float sueldo, String nombre, String apellido, 
            Direccion direccion) {
        //llama a la clase padre
        super(nombre, apellido, direccion);
        this.legajo = legajo;
        this.sueldo = sueldo;
    }

    @Override
    public void saludar() {
        System.out.println("Hola soy un empleado");
    }

    @Override
    public String toString() {
        return legajo + " " + sueldo + super.toString();
    }
    
    
}
