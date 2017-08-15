package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.interfaces.Archivo;
import ar.org.centro8.curso.java.utils.ArchivoBinario;
import ar.org.centro8.curso.java.utils.ArchivoTexto;
import java.util.Scanner;

public class TestInterfaces {
    public static void main(String[] args) throws Exception{
        Archivo archivo = null;
        
        archivo = new ArchivoTexto();
        //archivo = new ArchivoBinario();
        
        System.out.println("Ingrese 'Archivo Texto' o 'Archivo Binario': ");
        String respuesta = new Scanner(System.in).nextLine();
        
        //if (respuesta.equals("ArchivoBinario")) archivo = new ArchivoBinario(); 
        //if (respuesta.equals("ArchivoTexto")) archivo = new ArchivoTexto();    
        
        respuesta = "ar.org.centro8.curso.java.utils."+respuesta;
        archivo = (Archivo)Class.forName(respuesta).newInstance();
        
        archivo.setFile("c:/texto.txt");
        archivo.setText("hola");
        archivo.appendText("Hola");
        archivo.print();
        archivo.info();
    }
}
