package test;

import java.util.LinkedList;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.exception.RegionException;

/**
 *
 * @author ASaburov
 */
public class RegionFacade {
    
    private RegionDAO regionDAO;

    public void setRegionDAO(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    @Transactional(readOnly=false, propagation= Propagation.REQUIRED)
    public RegionView addRegion(RegionView rv) {
        Region r = RegionView.fromView(rv);
        Long id = (Long)regionDAO.addEntity(r);
        r.setRegionId(id);
        return RegionView.fromEntity(r);
    }

    @Transactional(readOnly=false, propagation= Propagation.REQUIRED)
    public void deleteRegion(Long regionId) throws RegionException {
        if(regionId==null || regionId.equals(0)) {
            throw new RegionException("Wrong RegionID parameter");
        }
        regionDAO.deleteEntity(regionDAO.getEntity(regionId));
    }
    
    @Transactional(readOnly=true, propagation= Propagation.REQUIRED)
    public RegionView getRegion(Long regionId) {
        return new RegionView(regionDAO.getEntity(regionId));
    }
    
    @Transactional(readOnly=true, propagation= Propagation.REQUIRED)
    public List<RegionView> findRegion() {
        List<RegionView> res = new LinkedList<RegionView>();
        List<Region> list = regionDAO.findregion();
        for(Region r : list) {
            res.add(new RegionView(r));
        }
        return res;
    }
}
