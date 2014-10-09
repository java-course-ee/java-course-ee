package com.geminisystems.subscription.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 15.08.2012
 * Time: 16:43:12
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_PATH")
public class SPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATH_ID", nullable = false, length = 10)
    private Integer pathId;

    @Column(name = "PATH_VALUE", nullable = false)
    private String pathValue;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private SCategory category;


    public SPath() {
    }

    public SPath(String pathValue) {
        this.pathValue = pathValue;
    }

    public Integer getPathId() {
        return pathId;
    }

    public void setPathId(Integer pathId) {
        this.pathId = pathId;
    }

    public String getPathValue() {
        return pathValue;
    }

    public void setPathValue(String pathValue) {
        this.pathValue = pathValue;
    }

    public SCategory getCategory() {
        return category;
    }

    public void setCategory(SCategory category) {
        this.category = category;
    }

   
}
