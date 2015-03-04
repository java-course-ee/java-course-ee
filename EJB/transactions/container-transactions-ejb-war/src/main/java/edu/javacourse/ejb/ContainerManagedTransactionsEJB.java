package edu.javacourse.ejb;

import edu.javacourse.ejb.staff.BusinessException;
import edu.javacourse.ejb.staff.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Stateless
@LocalBean
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ContainerManagedTransactionsEJB {

    private Logger log = LoggerFactory.getLogger(ContainerManagedTransactionsEJB.class);

    @Resource(mappedName = "java:/jdbc/JavaCourse", type = DataSource.class)
    private DataSource dataSource;

    /* !!! WARNING !!! for all methods. Don't close connections and other resources like that. Use finally block. */

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Region> getAllRegions() throws BusinessException {
        List<Region> regions = new LinkedList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select region_id, region_name from region.jc_region");
             ResultSet rs = statement.executeQuery();) {
            log.debug("AutoCommit AllRegions: {}", connection.getAutoCommit());

            while (rs.next()) {
                regions.add(new Region(rs.getLong(1), rs.getString(2)));
            }
            return regions;
        } catch (SQLException ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            throw new BusinessException(ex);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateRegionWithTransaction(Region region) throws BusinessException {
        try {
            Connection connection = dataSource.getConnection();

            log.debug("AutoCommit WithTransaction: {}", connection.getAutoCommit());

            PreparedStatement statement = connection.prepareStatement("update region.jc_region set region_name = ? where region_id = ?");
            statement.setString(1, region.getName());
            statement.setLong(2, region.getId());
            final int updateCount = statement.executeUpdate();
            log.debug("UpdateCount WithTransaction: {}", updateCount);
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            throw new BusinessException(ex.getMessage());
        }
        if (true) throw new BusinessException("Manual transaction rollback");
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void updateRegionWithNoTransaction(Region region) throws BusinessException {
        try {
            Connection connection = dataSource.getConnection();

            log.debug("AutoCommit WithNoTransaction: {}", connection.getAutoCommit());

            PreparedStatement statement = connection.prepareStatement("update region.jc_region set region_name = ? where region_id = ?");
            statement.setString(1, region.getName());
            statement.setLong(2, region.getId());
            final int updateCount = statement.executeUpdate();
            log.debug("UpdateCount WithNoTransaction: {}", updateCount);
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            throw new BusinessException(ex.getMessage());
        }
        if (true) throw new BusinessException("Manual transaction rollback");
    }

}
