package edu.javacourse.dwr;

import edu.javacourse.dwr.dao.entity.Region;
import edu.javacourse.dwr.view.RegionView;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Utils {

    public static Region transformView(RegionView rv) {
        Region region = new Region();
        region.setRegionId(rv.getRegionId());
        region.setName(rv.getRegionName());
        return region;
    }

    public static RegionView transformEntity(Region rv) {
        RegionView region = new RegionView();
        region.setRegionId(rv.getRegionId());
        region.setRegionName(rv.getName());
        return region;
    }

}
