package nocheclase06;

public class Vuelo {
    
    private String nombre;
    private int pasajes;

    public Vuelo(String nombre, int pasajes) {
        this.nombre = nombre;
        this.pasajes = pasajes;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "nombre=" + nombre + ", pasajes=" + pasajes + '}';
    }
    //multi hilo
    public synchronized void venderPasajes(int cantidad)throws NoHayMasPasajesException{
        if (cantidad > pasajes) throw new NoHayMasPasajesException(nombre, cantidad);
            
        pasajes -= cantidad;
    }
    
    public void metodo(){
        System.out.println("Se ejecuto el metodo.");
    }
}
