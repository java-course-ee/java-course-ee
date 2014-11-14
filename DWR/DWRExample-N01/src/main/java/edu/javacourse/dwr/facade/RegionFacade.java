package edu.javacourse.dwr.facade;

import edu.javacourse.dwr.Utils;
import edu.javacourse.dwr.dao.RegionDAO;
import edu.javacourse.dwr.dao.entity.Region;
import edu.javacourse.dwr.exception.RegionException;
import edu.javacourse.dwr.view.RegionView;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ASaburov
 */
public class RegionFacade {

    private RegionDAO regionDAO;

    public void setRegionDAO(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public RegionView addRegion(RegionView rv) {
        Region r = Utils.transformView(rv);
        Long id = (Long) regionDAO.addEntity(r);
        r.setRegionId(id);
        return Utils.transformEntity(r);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteRegion(Long regionId) throws RegionException {
        if (regionId == null || regionId.longValue() <= 0) {
            throw new RegionException("Wrong RegionID parameter");
        }
        regionDAO.deleteEntity(regionDAO.getEntity(regionId));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public RegionView getRegion(Long regionId) {
        return Utils.transformEntity(regionDAO.getEntity(regionId));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<RegionView> findRegion() {
        List<RegionView> res = new LinkedList<RegionView>();
        List<Region> list = regionDAO.findregion();
        for (Region region : list) {
            res.add(Utils.transformEntity(region));
        }
        return res;
    }
}
