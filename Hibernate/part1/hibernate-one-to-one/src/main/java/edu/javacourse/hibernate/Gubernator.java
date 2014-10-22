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
@Table(name = "jc_region_ext")
public class Gubernator implements Serializable {

    @Id
    @Column(name = "region_ext_id", unique = true, nullable = false)
    @GenericGenerator(name="gen", strategy="foreign",
            parameters=@Parameter(name="property", value="region"))
    @GeneratedValue(generator="gen")
    private Long regionId;


    @Column(name = "region_leader")
    private String leader;


    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Region region;


    public Gubernator() {
    }

    public Gubernator(String leader) {
        this.leader = leader;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
