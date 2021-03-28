package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Statement;

public class Main05 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book = new Book();
        book.setTitle("W póstyni i w pószczy");
        session.save(book);
        transaction.commit();
        System.out.println(session.createQuery("from Book", Book.class).list());
        session.close();

    }
}