/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad.ejhibernatelibreria;

import java.util.Scanner;
import menu.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utilidades.Log;

/**
 *
 * @author a20armandocb
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static private Log log = Log.getInstance();

    public static void main(String[] args) {
        boolean continuar = true;

        Menu menu = construirMenuPrincipal();

        do {
            try {
                continuar = menuAcciones(menu);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } while (continuar);

    }

    private static Menu construirMenuPrincipal() {
        Menu menu = new Menu();
        App app = new App();

        menu.setTituloMenu("Menu Ej. Hibernate");
        menu.setTextoSalir("salir");
        log.addToLog("iniciado el programa");
        
        menu.addOpcion("Insertar Filas", () -> {
            app.demo();
        });
        
        menu.addOpcion("Borrar Filas", () -> {
            app.eliminar();
        });
        
        menu.addOpcion("Modificarfilas", () -> {
           app.modificar();
        });
        
        menu.addOpcion("Consultar Autor", () -> {
           app.consultarAutor();
        });
        
        menu.addOpcion("Consultar Libro", () -> {
           app.consultarLibro();
        });
        menu.addOpcion("Listar Libros", () -> {
           app.listarLibros();
        });
        menu.addOpcion("Listar Autores", () -> {
           app.listarAutores();
        });
        menu.addOpcion("Eliminar Autores", () -> {
           app.eliminarAutores();
        });

//        menu.addOpcion("Pedir un texto Obligatorio", () -> {
//            peticiones.SalidasGui.mensaje(peticiones.EntradasGui.pedirString("Texto obligatorio entre 1 y 3", 3, 1, true));
//        });
//        menu.addOpcion("Pedir un texto NO Obligatorio", () -> {
//            peticiones.SalidasGui.mensaje(peticiones.EntradasGui.pedirString("Texto opcional entre 1 y 3", 3, 1, false));
//        });

        menu.addLabel("LOG");
        menu.addOpcion("Ver Log", () -> {
            peticiones.SalidasGui.bloqueTexto("Log", utilidades.Log.getInstance().getLog());
        });
        menu.addOpcion("Borrar Log", () -> {
            utilidades.Log.getInstance().borrarLog();
        });
        menu.addLabel("LOG");

        return menu;
    }

    private static boolean menuAcciones(Menu menu) throws Exception {
        boolean continuar = true;
        menu.mostrarGUI();
        //menu.mostrar();
        switch (menu.getSeleccion()) {
            case 0:
                //salir
                continuar = false;
                log.addToLog("finalizado el programa");
                System.out.println("Bye Bye!");
                break;
            //deprecated, ahora se asigna directamente la funcion al añadir el boton
//            case 1:
//                System.out.println(EntradasGui.pedirFecha("mensaje").toString());
//                break;
//            default:
//                System.out.println("opcion incorrecta");
//                break;

        }
        return continuar;
    }

}
