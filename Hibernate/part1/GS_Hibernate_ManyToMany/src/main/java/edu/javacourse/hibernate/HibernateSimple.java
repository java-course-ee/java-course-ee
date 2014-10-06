package edu.javacourse.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Простой пример для демонстрации иерархии
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        
        List<Book> bookList = s.createQuery("from Book").list();
        for(Book book: bookList) {
            System.out.println();
            System.out.println(book);
            for(Author author : book.getAuthorList()) {
                System.out.println(author);
            }
        }
        
        Author oldAuthor = bookList.get(0).getAuthorList().iterator().next();
        Book oldBook = bookList.get(0);
        
        hs.saveBook(oldAuthor, s);
       // hs.saveAuthor(oldBook, s);
        
        // Если не закрыть - то вылетает ошибка
        s.getTransaction().commit();
        s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        
        bookList = s.createQuery("from Book").list();
        for(Book book: bookList) {
            System.out.println();
            System.out.println(book);
            for(Author author : book.getAuthorList()) {
                System.out.println(author);
            }
        }
        
        s.getTransaction().commit();
    }

    private void saveBook(Author oldAuthor, Session s) throws HibernateException {
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
        return new Configuration().configure().buildSessionFactory();
    }
    
}
