/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernatelibreria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author a20armandocb
 */
public class App {

    public App() {

    }

    public static void demo() {

        Autor a1 = new Autor("53170624Y", "Armando", "Española", new Telefono("53170624Y", "986 123 456"));
        Autor a2 = new Autor("12345678Z", "Marcos", "Española", new Telefono("12345678Z", "986 333 444"));

        Libro lib1 = new Libro("Un Tutorial de Ejemplo", 9.95F);
        Libro lib2 = new Libro("Las Disculpas", 4.95F);
        Libro lib3 = new Libro("Los TRes", 14.95F);

        a1.getLibros().add(lib1);
        lib1.getAutores().add(a1);

        a1.getLibros().add(lib2);
        lib2.getAutores().add(a1);

        a2.getLibros().add(lib3);
        lib3.getAutores().add(a2);

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session=sessionFactory.openSession();
        Session session = (new Configuration().configure().buildSessionFactory()).openSession();

        session.beginTransaction();

        session.save(a1);
        session.save(a2);

        session.getTransaction().commit();
        session.close();

    }

    public static void consultar() {

        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        //session.beginTransaction();
//        session.getTransaction().commit();        
        Autor a1 = (Autor) (session.get(Autor.class, "53170624Y"));
        System.out.println("\n------------------\n");
        System.out.println(a1.toString());
        System.out.println("\n------------------\n");
        session.close();
    }

    public static void modificar() {
        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        Autor a1 = (Autor) (session.get(Autor.class, "53170624Y"));
        a1.setNombre("Fernando");
        a1.setTelefono(new Telefono(a1.getDni(),"111 222 333"));
        session.beginTransaction();
        session.update(a1);
        session.getTransaction().commit();
    }

    public static void eliminar() {
        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        Autor a1 = (Autor) (session.get(Autor.class, "53170624Y"));
        session.beginTransaction();
        session.delete(a1);
        session.getTransaction().commit();
    }

}
