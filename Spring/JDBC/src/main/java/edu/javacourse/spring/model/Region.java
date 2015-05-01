package edu.javacourse.spring.model;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 21.07.13
 */
public class Region {

    private Integer regionId;
    private String regionName;
    private List<City> cities;

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", regionName='" + regionName + '\'' +
                ", cities=" + cities +
                '}';
    }
}
