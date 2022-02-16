/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejhibernatelibreria;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import peticiones.EntradasGui;

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
        Autor a3 = new Autor("83271544Z", "Elena", "Española", new Telefono("83271544Z", "986 123 456"));

        Libro lib1 = new Libro("Un Tutorial de Ejemplo", 9.95F);
        Libro lib2 = new Libro("Las Disculpas", 4.95F);
        Libro lib3 = new Libro("Los TRes", 14.95F);
        Libro lib4 = new Libro("Los Cuatro", 44.95F);

        a1.getLibros().add(lib1);
        lib1.getAutores().add(a1);

        a1.getLibros().add(lib2);
        lib2.getAutores().add(a1);

        a2.getLibros().add(lib3);
        lib3.getAutores().add(a2);

        a3.getLibros().add(lib4);
        lib4.getAutores().add(a3);

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session=sessionFactory.openSession();
        Session session = (new Configuration().configure().buildSessionFactory()).openSession();

        session.beginTransaction();

        session.save(a1);
        session.save(a2);
        session.save(a3);

        session.getTransaction().commit();
        session.close();

    }

    public static void consultarAutor() {

        //session.beginTransaction();
//        session.getTransaction().commit();           
        String dni = EntradasGui.pedirString("indica el dni del autor");
        if (dni != null) {
            System.out.println("Buscado dni: " + dni);

            Session session = (new Configuration().configure().buildSessionFactory()).openSession();

            Autor autor = (Autor) (session.get(Autor.class, dni));
            //Object ob ;
            if (autor != null) {
//            if((ob = session.get(Autor.class, dni)) != null){                            
                System.out.println("---------------------");
                System.out.println(autor.toString());
                System.out.println("---------------------");
            } else {
                System.out.println("No se ha encontrado el autor con dni: " + dni);
            }

            session.close();

        }

    }

    public static void listarAutores() {

        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        List<Autor> autores = session.createQuery("SELECT b FROM Autor b", Autor.class).list();

        if (!autores.isEmpty()) {
            for (Autor autor : autores) {
                System.out.println("---------------------");
                System.out.println(autor.toString());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No hay libros");
        }
        session.close();
    }

    public static void listarLibros() {

        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        List<Libro> libros = session.createQuery("SELECT b FROM Libro b", Libro.class).list();

        if (!libros.isEmpty()) {
            for (Libro libro : libros) {
                System.out.println("---------------------");
                System.out.println(libro.toString());
                System.out.println("---------------------");
            }
        } else {
            System.out.println("No hay libros");
        }
        session.close();
    }

    public static void consultarLibro() {
        String titulo = EntradasGui.pedirString("indica parte del titulo del autor");
        if (titulo != null) {

            Session session = (new Configuration().configure().buildSessionFactory()).openSession();
            //session.beginTransaction();
//        session.getTransaction().commit();        

//            List<Libro> libros = session.createQuery("SELECT b FROM Libro b WHERE b.titulo = :titulo", Libro.class)
//                                .setParameter("titulo", titulo).list();
            //con Like
            List<Libro> libros = session.createQuery("SELECT b FROM Libro b WHERE b.titulo LIKE :titulo", Libro.class
            )
                    .setParameter("titulo", "%" + titulo + "%").list();

            if (!libros.isEmpty()) {
                for (Libro libro : libros) {
                    System.out.println("---------------------");
                    System.out.println(libro.toString());
                    System.out.println("---------------------");
                }
            } else {
                System.out.println("No hay concordancias para libros con: " + titulo);
            }
            session.close();
        }

    }

    public static void modificar() {
        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        Autor a1 = (Autor) (session.get(Autor.class,
                "53170624Y"));
        a1.setNombre("Fernando");
        a1.setTelefono(new Telefono(a1.getDni(), "111 222 333"));
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

    public static void eliminarAutores() {
        Session session = (new Configuration().configure().buildSessionFactory()).openSession();
        List<Autor> autores = session.createQuery("SELECT b FROM Autor b", Autor.class).list();

        if (!autores.isEmpty()) {
            session.beginTransaction();
            for (Autor autor : autores) {
                System.out.println(autor.getNombre() + " ---- Borrando....");
                session.delete(autor);
            }
            session.getTransaction().commit();
            System.out.println("- - - - elementos eliminados - - -");
        } else {
            System.out.println("No hay libros");
        }
        session.close();
    }
}
