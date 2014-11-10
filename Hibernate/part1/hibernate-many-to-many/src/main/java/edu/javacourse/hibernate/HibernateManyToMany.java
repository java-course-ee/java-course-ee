package edu.javacourse.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Простой пример для демонстрации иерархии
 *
 * @author ASaburov
 */
public class HibernateManyToMany {

    private static final Logger log = LoggerFactory.getLogger(HibernateManyToMany.class);

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    private static void init() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static void main(String[] args) {
        init();

        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        Author oldAuthor = new Author();
        oldAuthor.setAuthorName("New Author 0");
        s.save(oldAuthor);

        saveBook(oldAuthor, s);

        List<Book> bookList = s.createCriteria(Book.class).list();
        for (Book book : bookList) {
            log.debug("");
            log.debug("Book: {}", book);
            for (Author author : book.getAuthorList()) {
                log.debug("Author: {}", author);
            }
        }

        oldAuthor = bookList.get(0).getAuthorList().iterator().next();
        Book oldBook = bookList.get(0);

        saveBook(oldAuthor, s);
        // saveAuthor(oldBook, s);

        // Если не закрыть - то вылетает ошибка
        s.getTransaction().commit();

        s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        bookList = s.createCriteria(Book.class).list();
        for (Book book : bookList) {
            log.debug("");
            log.debug("Book: {}", book);
            for (Author author : book.getAuthorList()) {
                log.debug("Author: {}", author);
            }
        }

        s.getTransaction().commit();

        log.debug("Transaction committed");

        destroy();
    }

    private static void saveBook(Author oldAuthor, Session s) throws HibernateException {
        Book newBook = new Book();
        newBook.setBookName("New book 1");

        // Вариант добавления новой книги и существуюего автора
        newBook.addAuthor(oldAuthor);

        // Вариант добавления нового автора к новой книге
        Author newAuthor = new Author();
        newAuthor.setAuthorName("New Author 1");
        // Нет надобности добавлять книгу к автору
        // Если связь однонаправленная - то не проблема. Иначе будет забавный эффект
        //newAuthor.addBook(newBook);

        newBook.addAuthor(newAuthor);
        s.save(newAuthor);


        s.save(newBook);
    }

    private void saveAuthor(Book oldBook, Session s) throws HibernateException {
        Author newAuthor = new Author();
        newAuthor.setAuthorName("New Author 2");

        // Вариант добавления новой книги и существуюего автора
        newAuthor.addBook(oldBook);

        // Вариант добавления нового автора к новой книге
        Book newBook = new Book();
        newBook.setBookName("New Book 2");
        // Нет надобности добавлять автора к книге
        // Если связь однонаправленная - то не проблема. Иначе будет забавный эффект
        //newBook.addAuthor(newAuthor);
        newAuthor.addBook(newBook);
        s.save(newBook);

        s.save(newAuthor);
    }


    private SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory(
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build()
        );
        return sessionFactory;

    }
}
