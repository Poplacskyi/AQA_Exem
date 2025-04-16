package orm.dao;

import orm.entities.TestResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestResultDAO {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(TestResult result) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(result);
        session.getTransaction().commit();
        session.close();
    }

    public void close() {
        sessionFactory.close();
    }
}
