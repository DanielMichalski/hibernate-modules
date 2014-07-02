import entity.Klient;
import entity.Zamowienie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

//        HQL Querys
//        getAllKlients(session);
//        getNameAndSurnameKlients(session);
//        getNameAndSurnameOneKlient(session);
//        getNameAndSurnameWhereKlientSurname(session);
//        connectionsBetweenEntities1(session);
//        connectionsBetweenEntities2(session);
//        groupBy(session);
//        update(session);
        delete(session);
    }

    private static void getAllKlients(Session session) {
        Query q = session.createQuery("from Klient");
        List<Klient> result = q.list();

        for (Klient klient : result) {
            System.out.println(klient);
        }
    }

    private static void getNameAndSurnameKlients(Session session) {
        Query q = session.createQuery("SELECT imie, nazwisko from Klient");
        List result = q.list();

        for (Object o : result) {
            Object[] objects = (Object[]) o;
            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    private static void getNameAndSurnameOneKlient(Session session) {
        Query q = session.createQuery("SELECT imie, nazwisko from Klient")
                .setFirstResult(1)
                .setMaxResults(1);
        List result = q.list();

        for (Object o : result) {
            Object[] objects = (Object[]) o;
            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    private static void getNameAndSurnameWhereKlient(Session session) {
        Query q = session.createQuery("SELECT imie, nazwisko from Klient where nazwisko = 'Kowalski'");
        List result = q.list();

        for (Object o : result) {
            Object[] objects = (Object[]) o;
            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    private static void getNameAndSurnameWhereKlientSurname(Session session) {
        String nazwisko = "Kowalski";
        Query q = session.createQuery("SELECT imie, nazwisko from Klient where nazwisko=:nazwisko")
                .setString("nazwisko", nazwisko);
        List result = q.list();

        for (Object o : result) {
            Object[] objects = (Object[]) o;
            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    private static void connectionsBetweenEntities1(Session session) {
        Query q = session.createQuery("from Zamowienie z where z.klient.nazwisko='Kowalski'");
        List<Zamowienie> result = q.list();

        for (Zamowienie zamowienie : result) {
            System.out.println(zamowienie.getId() + " " + zamowienie.getAdres());
        }
    }

    private static void connectionsBetweenEntities2(Session session) {
        Query q = session.createQuery("from Klient k join k.zamowienia as z with z.data > '2011-12-15' order by k.imie");
        List result = q.list();
        for (Object o : result) {
            Object[] array = (Object[]) o;
            Klient k = (Klient) array[0];
            Zamowienie z = (Zamowienie) array[1];
            System.out.println(k.getImie() + " " + k.getNazwisko());
        }

    }

    private static void groupBy(Session session) {
        Query q = session.createQuery("select k.nazwisko, count(*) as liczba from Klient k group by k.nazwisko having k.nazwisko like 'K%'");
        List list = q.list();
        for (Object o : list) {
            Object[] objects = (Object[]) o;
            String nazwisko = (String) objects[0];
            long liczba = (Long)objects[1];
            System.out.println(nazwisko + " " + liczba);
        }
    }

    private static void update(Session session) {
        Transaction transaction = session.beginTransaction();
        int howMany = session.createQuery("update Klient k set k.imie = :nowa where k.imie = :stara")
                .setString("nowa", "Janek")
                .setString("stara", "Jan")
                .executeUpdate();
        transaction.commit();

        System.out.println("Aktualizowano wierszy: " + howMany);
    }

    private static void delete(Session session) {
        Transaction transaction = session.beginTransaction();
        int howMany = session.createQuery("delete Klient k where k.id = 1")
                .executeUpdate();
        transaction.commit();

        System.out.println("Usunieto wierszy: " + howMany);
    }
}
