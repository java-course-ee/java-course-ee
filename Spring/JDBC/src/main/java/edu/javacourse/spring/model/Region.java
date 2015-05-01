package edu.javacourse.spring.model;

/**
 * Author: Georgy Gobozov
 * Date: 21.07.13
 */
public class Region {

    private Integer regionId;
    private String regionName;

    public Region() {
    }

    public Region(Integer regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public Region(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
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
        return "Region{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
