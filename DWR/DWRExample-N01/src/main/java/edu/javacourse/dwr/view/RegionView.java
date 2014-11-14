package edu.javacourse.dwr.view;

/**
 * @author ASaburov
 */
public class RegionView {

    private Long regionId;
    private String regionName;

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
        final StringBuilder sb = new StringBuilder("RegionView{");
        sb.append("regionId=").append(regionId);
        sb.append(", regionName='").append(regionName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
