package ar.org.centro8.curso.java.utils;

import ar.org.centro8.curso.java.interfaces.Archivo;

public class ArchivoBinario implements Archivo {
    
    private String file;
    
    @Override
    public void setFile(String file) {
        this.file = file;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getFile() {
        //return this.file;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo Archivo Binario");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setText(String text) {
        System.out.println("Escribiendo Archivo Binario");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void appendText(String text) {
        System.out.println("Apendizando Archivo Binario");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTex() {
        return "Archivo Binario";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
