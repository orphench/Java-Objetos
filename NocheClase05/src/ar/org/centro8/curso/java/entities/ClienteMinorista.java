package ar.org.centro8.curso.java.entities;

public class ClienteMinorista {
    
    private int nro;
    private String nombre;
    private String direccion;
    private Cuenta cuenta;

    public ClienteMinorista(int nro, String nombre, String direccion, int nroCuenta) {
        this.nro = nro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuenta = new Cuenta(nroCuenta, "arg$");
    }

    public int getNro() {return nro;}

    public String getNombre() {return nombre;}

    public String getDireccion() {return direccion;}

    public Cuenta getCuenta() {return cuenta;}

    @Override
    public String toString() {
        return nro + " " + nombre + " " + direccion;
    }
    
    
}
