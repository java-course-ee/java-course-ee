package edu.javacourse.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jc_region")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;
    @Column(name = "region_name", nullable = true)
    private String regionName;
    // Если поле не должно сохраняться, то его либо помечают тэгом @Transient
    // либо просто объявляют transient
    @Transient
    private String unsaved;
    //private transient String unsaved;

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

    public String getUnsaved() {
        return unsaved;
    }

    public void setUnsaved(String unsaved) {
        this.unsaved = unsaved;
    }

    @Override
    public String toString() {
        return regionId + ":" + regionName;
    }
}
