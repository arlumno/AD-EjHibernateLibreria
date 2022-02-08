/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernatelibreria;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name = "Autores")
public class Autor {

    @Id
    @Column(name = "DniAutor")
    private String dni;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Nacionalidad")
    private String Nacionalidad;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "autores")
    private Set<Libro> libros = new HashSet();

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Telefono telefono;

    public Autor() {
    }

    public Autor(String dni, String nombre, String Nacionalidad, Telefono telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.Nacionalidad = Nacionalidad;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> autores) {
        this.libros = autores;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
    
    
}
