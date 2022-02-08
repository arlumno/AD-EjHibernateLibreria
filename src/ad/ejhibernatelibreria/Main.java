/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad.ejhibernatelibreria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author a20armandocb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        
        Autor a1 = new Autor("53170624Y", "Armando", "Española", new Telefono("53170624Y","986 123 456"));
        
        Libro lib1 = new Libro(1, "Un Tutorial de Ejemplo", 9.95F);
        Libro lib2 = new Libro(2, "Las Disculpas", 4.95F);
        
        a1.getLibros().add(lib1);
        a1.getLibros().add(lib2);
        
        lib1.getAutores().add(a1);
        lib2.getAutores().add(a1);
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(a1);
        
        session.getTransaction().commit();
        session.close();
        
        
    }

}
