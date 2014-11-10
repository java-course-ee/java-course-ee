package edu.javacourse.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jc_book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "book_name")
    private String bookName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "jc_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authorList;

    public Set<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(Set<Author> authorList) {
        this.authorList = authorList;
    }

    public void addAuthor(Author author) {
        if (authorList == null) {
            authorList = new HashSet<Author>();
        }
        authorList.add(author);
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.bookId != other.bookId && (this.bookId == null || !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.bookId != null ? this.bookId.hashCode() : 0);
        return hash;
    }
}
