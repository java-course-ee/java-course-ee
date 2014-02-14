package test;

/**
 *
 * @author ASaburov
 */
public class RegionView {

    private Long regionId;
    private String regionName;

    public RegionView() {
    }

    public RegionView(Region region) {
        this.regionId = region.getRegionId();
        this.regionName = region.getName();
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

    public static Region fromView(RegionView rv) {
        Region region = new Region();
        region.setRegionId(rv.getRegionId());
        region.setName(rv.getRegionName());
        return region;
    }
    
    public static RegionView fromEntity(Region rv) {
        RegionView region = new RegionView();
        region.setRegionId(rv.getRegionId());
        region.setRegionName(rv.getName());
        return region;
    }
}
