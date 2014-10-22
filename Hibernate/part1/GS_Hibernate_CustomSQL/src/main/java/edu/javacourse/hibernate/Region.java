package edu.javacourse.hibernate;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "jc_region")
@SQLInsert(sql = "INSERT INTO jc_region (region_name) VALUES(?)")
@SQLUpdate(sql = "UPDATE jc_region SET region_name = ? WHERE region_id = ?")
@SQLDelete(sql = "DELETE FROM jc_region WHERE region_id = ?")
@Loader(namedQuery = "region")
@NamedNativeQuery(
        name = "region",
        query = "SELECT region_id, region_name FROM jc_region WHERE region_id=?",
        resultClass = Region.class
)
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;
    @Column(name = "region_name", nullable = true)
    private String regionName;

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

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", regionName=" + regionName + '}';
    }
}
