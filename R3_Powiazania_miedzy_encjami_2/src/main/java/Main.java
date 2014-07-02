import entity.Klient;
import entity.Telefon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        get(session);
    }

    private static void get(Session session) {
        Klient klient = (Klient) session.get(Klient.class, 1);
        for (Telefon telefon : klient.getTelefony()) {
            System.out.println(telefon.getModel() +  " " + telefon.getNumer());
        }
        for (Map.Entry<String, String> wpis : klient.getNumeryModele().entrySet()) {
            System.out.println(wpis.getKey() + " " + wpis.getValue());
        }
    }
}
