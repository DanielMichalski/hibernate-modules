import entity.KlientEntity;

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

        KlientEntity klient = manager.find(KlientEntity.class, 2 );
        System.out.println(klient);
    }
}
