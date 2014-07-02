import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        List list = session.createQuery("select c.imie from Client c ").list();
        System.out.println(list.size());
    }
}
