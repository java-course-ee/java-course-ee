package com.geminisystems.subscription.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 27.08.2012
 * Time: 18:18:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_SUBSCRIPTION_MEDIA")
public class SMediaContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;

    @Column(name = "CATEGORY_TITLE", nullable = false)
    private String title;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "TEXT", nullable = false, length = 1000)
    private String text;

    @Column(name = "DESCRIPTION", nullable = true, length = 10000)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
