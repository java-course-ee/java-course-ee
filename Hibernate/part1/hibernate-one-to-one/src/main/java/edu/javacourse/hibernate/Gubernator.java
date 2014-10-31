package edu.javacourse.hibernate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: Georgy Gobozov
 * Date: 26.06.13
 */
@Entity
@Table(name = "jc_gubernator")
public class Gubernator implements Serializable {

    @Id
    @Column(name = "region_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(
            name = "gen",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "region")
    )
    private Long regionId;

    @Column(name = "name")
    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Region region;

    public Gubernator() {
    }

    public Gubernator(String name) {
        this.name = name;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
