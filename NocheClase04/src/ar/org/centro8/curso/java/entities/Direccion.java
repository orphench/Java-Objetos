package ar.org.centro8.curso.java.entities;

public class Direccion {
    
    private String calle;
    private String nro;
    private String piso;
    private String depto;
    private String localidad;
    
    /**
     * Constructor para direcciones de CABA
     * @param calle
     * @param nro
     * @param piso
     * @param depto 
     */
    public Direccion(String calle, String nro, String piso, String depto) {
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.depto = depto;
        this.localidad = "CABA";
    }
    
    /**
     * Constructor para direcciones fuera de CABA
     * @param calle
     * @param nro
     * @param piso
     * @param depto
     * @param localidad 
     */
    public Direccion(String calle, String nro, String piso, String depto, String localidad) {
        this.calle = calle;
        this.nro = nro;
        this.piso = piso;
        this.depto = depto;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return calle + " " + nro + " " + piso + " " + depto + " " + localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
}
