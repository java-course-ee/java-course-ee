package com.geminisystems.subscription.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 16.11.2011
 * Time: 14:14:27
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_CATEGORY")
public class SCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", nullable = false, length = 10)
    private Integer categoryId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AT_NAME")
    private String atName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    //@Fetch(value = FetchMode.SUBSELECT)    //http://stackoverflow.com/questions/4334970/hibernate-cannot-simultaneously-fetch-multiple-bags
    private List<SPath> paths;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "T_SUBSCRIPTION_CATEGORY",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBSCR_ID"))
    private List<SBean> subscriptions;

    public SCategory() {
    }

//    public SCategory(String title, String path, String atName) {
//        this.title = title;
//        this.path = path;
//        this.atName = atName;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }

    public String getAtName() {
        return atName;
    }

    public void setAtName(String atName) {
        this.atName = atName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<SBean> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SBean> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public boolean equals(Object obj) {
        return this.categoryId.equals(((SCategory) obj).categoryId);
    }

    public List<SPath> getPaths() {
        return paths;
    }

    public void setPaths(List<SPath> paths) {
        this.paths = paths;
    }

    
}
