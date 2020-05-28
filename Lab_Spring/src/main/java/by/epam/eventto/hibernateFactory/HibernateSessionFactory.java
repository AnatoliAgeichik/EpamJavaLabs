package by.epam.eventto.hibernateFactory;

import by.epam.eventto.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    //private HibernateSessionFactoryUtil() {}


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml"));
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Comment.class);
                configuration.addAnnotatedClass(Event.class);
                configuration.addAnnotatedClass(Members.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }
        return sessionFactory;
    }
}
