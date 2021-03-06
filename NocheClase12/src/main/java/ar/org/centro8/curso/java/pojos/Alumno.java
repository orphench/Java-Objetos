package ar.org.centro8.curso.java.pojos;
// Generated 04-sep-2017 19:41:35 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alumnos generated by hbm2java
 */
@Entity
@Table(name = "alumnos",catalog = "colegio")

public class Alumno implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer curso;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Alumno(String nombre, String apellido, Integer edad, Integer curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.curso = curso;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", nullable = false, length = 20)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido", nullable = false, length = 20)
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Column(name = "edad")
    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Column(name = "curso")
    public Integer getCurso() {
        return this.curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", curso=" + curso + '}';
    }
    
}
