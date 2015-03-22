package edu.javacourse.ejb;

import edu.javacourse.ejb.entity.Region;
import edu.javacourse.ejb.exception.BusinessException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@Stateless
@LocalBean
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ContainerManagedTransactionsEJBJPA {

    @PersistenceContext(unitName = "persistence")
    private EntityManager entityManager;

    private CriteriaBuilder criteriaBuilder;

    @PostConstruct
    public void init() {
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @PreDestroy
    public void destroy() {
        criteriaBuilder = null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Region> getAllRegions() throws BusinessException {
        CriteriaQuery<Region> criteria = criteriaBuilder.createQuery(Region.class);
        criteria.from(Region.class);
        TypedQuery<Region> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateRegionWithTransaction(Region region) throws BusinessException {
        entityManager.merge(region);
        entityManager.flush();
        if (true) throw new BusinessException("Manual transaction rollback");
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    // no update methods. just selects can be used here. this code will throw exception
    public void updateRegionWithNoTransaction(Region region) throws BusinessException {
        entityManager.merge(region);
        entityManager.flush();
        if (true) throw new BusinessException("Manual transaction rollback");
    }

}
