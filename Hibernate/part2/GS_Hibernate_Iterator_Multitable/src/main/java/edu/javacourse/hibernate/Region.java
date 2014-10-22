package edu.javacourse.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jc_region")
@SecondaryTables({
        @SecondaryTable(name = "jc_region_ext",
                pkJoinColumns = {
                        @PrimaryKeyJoinColumn(name = "region_ext_id", referencedColumnName = "region_id")
                })
})
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;
    @Column(name = "region_name", nullable = true)
    private String regionName;
    @Column(name = "region_leader", table = "jc_region_ext")
    private String regionLeader;

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

    public String getRegionLeader() {
        return regionLeader;
    }

    public void setRegionLeader(String regionLeader) {
        this.regionLeader = regionLeader;
    }

    @Override
    public String toString() {
        return regionId + ":" + regionName + ", " + regionLeader;
    }
}
