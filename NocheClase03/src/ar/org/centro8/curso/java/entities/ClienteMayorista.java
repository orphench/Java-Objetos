package ar.org.centro8.curso.java.entities;

public class ClienteMayorista {
    
    private int nro;
    private String razonSocial;
    private String direccion;
    private Cuenta[] cuentas;

    public ClienteMayorista(int nro, String razonSocial, String direccion) {
        this.nro = nro;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.cuentas = new Cuenta[3];
    }

    @Override
    public String toString() {
        return nro + " " + razonSocial + " " + direccion;
    }

    public int getNro() {return nro;}

    public String getRazonSocial() {return razonSocial;}

    public String getDireccion() {return direccion;}

    public Cuenta[] getCuentas() {return cuentas;}
    
    
    
    
}
