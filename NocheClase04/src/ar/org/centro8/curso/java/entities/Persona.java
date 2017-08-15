package ar.org.centro8.curso.java.entities;

public abstract class Persona {
    
    private String nombre;
    private String apellido;
    private Direccion direccion;

    public Persona(String nombre, String apellido, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return " " + nombre + " " + apellido + " " + direccion;
    }
    
    public void saludar(){
        System.out.println("hola soy una persona");
    }
}
