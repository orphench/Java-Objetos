package ar.org.centro8.curso.java.entities;

public class Cliente extends Persona {
    
    private int nro;
    private Cuenta cuenta;

    public Cliente(int nro, Cuenta cuenta, String nombre, String apellido, 
            Direccion direccion) {
        super(nombre, apellido, direccion);
        this.nro = nro;
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return nro + " " + super.toString();
    }

    @Override
    public void saludar() {
        System.out.println("Hola soy un cliente"); 
    }
    
    public Cuenta getCuenta(){ return this.cuenta;}
    
}
