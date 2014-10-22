package edu.javacourse.hibernate;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "jc_region")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "region_name", nullable = true)
    @OrderColumn // JPA 2.0
    private String regionName;


    @JoinColumn(name="region_ext_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "region")
    private Gubernator gubernator;

    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Gubernator getGubernator() {
        return gubernator;
    }

    public void setGubernator(Gubernator gubernator) {
        this.gubernator = gubernator;
    }

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", regionName=" + regionName + '}';
    }
}
