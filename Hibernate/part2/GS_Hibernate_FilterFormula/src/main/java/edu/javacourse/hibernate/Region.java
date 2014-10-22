package edu.javacourse.hibernate;

import org.hibernate.annotations.*;

import java.io.Serializable;

@Entity
@Table(name = "jc_region")
// Использование Where будет всегда в отличии от фильтра
//@Where(clause="region_id <= 2")
@FilterDef(name = "filterRegionId", parameters =
@ParamDef(name = "minId", type = "integer"))
@Filters({
        @Filter(name = "filterRegionId", condition = "region_id <= :minId")
})
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "region_name", nullable = true)
    @OrderColumn // JPA 2.0
    private String regionName;

    @Formula(value = "concat('Full Name = ', region_id, region_name )")
    private String fullName;

    @Formula(value = "case when region_id % 2 = 0 then 1 else 0 end")
    private boolean isEven; // четный

    @Formula("(SELECT COUNT(*) FROM jc_city AS city WHERE city.region_id = region_id)")
    private int citiesCount;


    public Region() {
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public int getCitiesCount() {
        return citiesCount;
    }

    public void setCitiesCount(int citiesCount) {
        this.citiesCount = citiesCount;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", regionName=" + regionName + '}';
    }
}
