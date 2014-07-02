import entity.Klient;
import entity.Zamowienie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

//        save(session);
        get(session);
    }

    private static void get(Session session) {
        Klient klient = (Klient) session.get(Klient.class, 1);
        System.out.println(klient);
    }

    private static void save(Session currentSession) {
        Transaction transaction = currentSession.beginTransaction();
        Klient klient = new Klient();
        klient.setImie("Jan");
        klient.setNazwisko("Nazwisko");
        Set<Zamowienie> zamowienia = new HashSet<Zamowienie>();

        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setAdres("Adres");
        zamowienie.setData(new Date());
        zamowienie.setKlient(klient);
        zamowienia.add(zamowienie);

        klient.setZamowienia(zamowienia);

        currentSession.persist(klient);
        transaction.commit();
    }
}
