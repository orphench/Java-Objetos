package nocheclase06;

public class NoHayMasPasajesException extends Exception{
    
    private String nombre;
    private int cantidad;

    public NoHayMasPasajesException(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "El vuelo " + nombre + ", no tiene " + cantidad + " pasajes";
    }
    
}
