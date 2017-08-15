package ar.org.centro8.curso.java.entities;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.nro;
        hash = 53 * hash + Objects.hashCode(this.moneda);
        hash = 53 * hash + Float.floatToIntBits(this.saldo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (this.nro != other.nro) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.moneda, other.moneda)) {
            return false;
        }
        return true;
    }
    
    
    
}
