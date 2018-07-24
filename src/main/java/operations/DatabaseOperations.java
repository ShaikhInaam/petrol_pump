package operations;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DatabaseOperations {

    static SessionFactory sessionFactory;

    public static void setup() {
        // code to load Hibernate Session factory

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }






    public static void exit() {
        // code to close Hibernate Session factory

        sessionFactory.close();
    }



    public static void create(Object obj) {
        // code to save

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(obj);

        session.getTransaction().commit();
        session.close();

        System.out.println("done");
    }




    public static List<?> read(String username,String password, Class c)throws Exception {
        // code to get

        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(c);
        cr.add(Restrictions.eq("username", username));
        cr.add(Restrictions.eq("password", password));
        List users = cr.list();

        session.getTransaction().commit();
        session.close();

        return users;

    }

}
