/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad.ejhibernatelibreria;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ar
 */
public class ConexionHibernateSF {

    private static SessionFactory sessionFactory;
    private static Session session;

    private ConexionHibernateSF() {        
    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {
        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    public static List createQueryList(String string, Class type) {
        return getSession().createQuery(string, type).list();
    }

    public static void close() {
        session.close();
    }
}
