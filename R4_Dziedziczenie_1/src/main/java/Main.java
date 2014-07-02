import entity.KlientFirmowy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        KlientFirmowy klientFirmowy = (KlientFirmowy) session.get(KlientFirmowy.class, 1);
        System.out.println(klientFirmowy.getNazwaFirmy() + " " + klientFirmowy.getNIP());
    }
}
