import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("jpaHibernateTest");

        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.commit();
        manager.close();
    }
}
