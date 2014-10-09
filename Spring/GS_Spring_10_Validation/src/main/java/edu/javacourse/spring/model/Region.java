package edu.javacourse.spring.model;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class Region {

    private Integer regionId;
    private String regionName;
    private int population;

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
