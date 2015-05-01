package edu.javacourse.spring.model;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class City {

    private Integer cityId;
    private String cityName;
    private Region region;

    public City(Integer cityId, String cityName, Region region) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.region = region;
    }

    public City() {
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
