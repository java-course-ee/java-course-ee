package edu.javacourse.hibernate.data;

import java.io.Serializable;

/**
 * Author: Georgy Gobozov
 * Date: 27.06.13
 */
@Entity
@Table(name = "hbm2_album")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Integer albumId;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @JoinColumn(name = "author_id")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Author authorr;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthorr() {
        return authorr;
    }

    public void setAuthorr(Author author) {
        this.authorr = author;
    }
}
