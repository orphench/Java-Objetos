package ar.org.centro8.curso.java.interfaces;

public interface Archivo {
    /*
    Las interfaces en java no pueden tener atributos ni
    constructores, solo puede tener metodos publicos y
    abastractos.
    Los metodos deben ser implementados por las clases
    que usen la interfaz.
    */
    
    void setFile(String file);
    void getFile();
    void print();
    void setText(String text);
    void appendText(String text);
    String getTex();
    
    //java 8 tiene metodos default
    default void info(){
        System.out.println("Interface  Archivo.");
    }
}
