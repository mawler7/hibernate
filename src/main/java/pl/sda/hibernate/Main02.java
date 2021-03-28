package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Long> query = session.createQuery("select count(*) from Book", Long.class);
        List<Long> books = query.list();
            System.out.println(query.uniqueResult());
        session.close();
    }
}
