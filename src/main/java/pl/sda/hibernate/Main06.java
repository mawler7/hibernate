package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main06 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.createQuery("from Book where title = 'W póstyni i w pószczy' ", Book.class).uniqueResult();
        if(book != null){
        book.setTitle("W pustyni i w puszczy");
        session.update(book);
        }
        transaction.commit();
        System.out.println(session.createQuery("from Book", Book.class).list());
        session.close();
    }
}