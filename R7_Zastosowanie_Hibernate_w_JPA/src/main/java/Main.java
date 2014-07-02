import entity.Produkt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("jpaHibernateTest");

        EntityManager manager = factory.createEntityManager();

        Produkt produkt = manager.find(Produkt.class, 1);

        System.out.println(produkt.getSkladniki().get(0).getZamowienie().getKlient().getNazwisko());

        manager.close();
    }
}
