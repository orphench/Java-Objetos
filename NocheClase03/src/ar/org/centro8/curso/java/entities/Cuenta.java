package ar.org.centro8.curso.java.entities;

public class Cuenta {
    
    private int nro;
    private String moneda;
    private float saldo;

    public Cuenta(int nro, String moneda) {
        this.nro = nro;
        this.moneda = moneda;
    }
    
    public void depositar(float monto){this.saldo += monto;}   
    public void debitar(float monto){saldo=(saldo>=monto)?saldo-monto:saldo;}

    @Override
    public String toString() {return nro + " " + moneda + " " + saldo;}

    public int getNro() {return nro;}

    public String getMoneda() {return moneda;}

    public float getSaldo() {return saldo;}
    
    
    
}
