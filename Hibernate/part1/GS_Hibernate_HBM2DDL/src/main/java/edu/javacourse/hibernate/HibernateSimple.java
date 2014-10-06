package edu.javacourse.hibernate;

import edu.javacourse.hibernate.data.Album;
import edu.javacourse.hibernate.data.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Простой пример работы со связанными таблицами
 * 
 * @author ASaburov
 */
public class HibernateSimple {

    public static void main(String[] args) {
        HibernateSimple hs = new HibernateSimple();

        Session s = hs.getSessionFactory().getCurrentSession();
        s.beginTransaction();




        Author metallica = new Author();
        metallica.setName("Metallica");
        //metallica.setAlbums(albums);
        s.save(metallica);

        Album album1 = new Album();
        album1.setName("Hard rock alnum!");
        album1.setAuthorr(metallica);
        s.save(album1);

        Album album2 = new Album();
        album2.setName("Best of Metallica");
        album2.setAuthorr(metallica);
        s.save(album2);

//        List<Album> albums = new ArrayList<Album>();
//        albums.add(album1);
//        albums.add(album2);





        s.getTransaction().commit();
    }

    private SessionFactory getSessionFactory() {
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }
}
