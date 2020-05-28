//package by.epam.eventto;
//
//import by.epam.eventto.entity.*;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;
//
//import java.util.Properties;
//
//public class HibernateConfig {
//    private static SessionFactory sessionFactory;
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//                // Hibernate settings equivalent to hibernate.cfg.xml's properties
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:orcl");
//                settings.put(Environment.USER, "eventto2");
//                settings.put(Environment.PASS, "root");
//                settings.put(Environment.JDBC_PASSWORD, "oracle");
//
//                //settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
//                configuration.setProperties(settings);
//                configuration.addAnnotatedClass(User.class);
//                configuration.addAnnotatedClass(Address.class);
//                configuration.addAnnotatedClass(Members.class);
//                configuration.addAnnotatedClass(Comment.class);
//                configuration.addAnnotatedClass(Event.class);
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties()).build();
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }
//
//}
