package edu.javacourse.hibernate;

public class RegionView {

    private String regionName;

    public RegionView(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public String toString() {
        return "RegionView{" + "regionName=" + regionName + '}';
    }
}
