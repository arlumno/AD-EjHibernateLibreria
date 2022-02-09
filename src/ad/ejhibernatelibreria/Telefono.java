/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernatelibreria;

import javax.persistence.*;

/**
 *
 * @author a20armandocb
 */
@Entity
@Table(name="Telefonos")
public class Telefono {
    
    @Id
    @Column(name = "Dni")
    private String dni;
    
    @Column(name = "NumeroTf")
    private String  numeroTf;        
    
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Autor autor;   

    public Telefono() {
    }
  
    public Telefono(String dni, String numeroTf) {
        this.dni = dni;
        this.numeroTf = numeroTf;        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroTf() {
        return numeroTf;
    }

    public void setNumeroTf(String numeroTf) {
        this.numeroTf = numeroTf;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Telefono{" + "dni=" + dni + ", numeroTf=" + numeroTf + '}';
    }
    
    
}
