package edu.javacourse.ejb;

import edu.javacourse.ejb.staff.BusinessException;
import edu.javacourse.ejb.staff.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
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
@TransactionManagement(value = TransactionManagementType.BEAN)
public class BeanManagedTransactionsEJB {

    private Logger log = LoggerFactory.getLogger(BeanManagedTransactionsEJB.class);

    @Resource(mappedName = "java:/jdbc/JavaCourse", type = DataSource.class)
    private DataSource dataSource;

    @Resource(mappedName = "java:comp/UserTransaction")
    private UserTransaction transaction;

    /* !!! WARNING !!! for all methods. Don't close connections and other resources like that. Use finally block. */

    public List<Region> getAllRegions() throws BusinessException {
        List<Region> regions = new LinkedList<>();
        try {
            transaction.begin();
            Connection connection = dataSource.getConnection();

            log.debug("AutoCommit AllRegions: {}", connection.getAutoCommit());

            PreparedStatement statement = connection.prepareStatement("select region_id, region_name from region.jc_region");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                regions.add(new Region(rs.getLong(1), rs.getString(2)));
            }
            transaction.commit();
            rs.close();
            statement.close();
            connection.close();
            return regions;
        } catch (Exception ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            try {
                transaction.rollback();
            } catch (SystemException e) {
                log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            }
            throw new BusinessException(ex);
        }
    }

    public void updateRegionWithTransactionRollback(Region region) throws BusinessException {
        try {
            transaction.begin();
            Connection connection = dataSource.getConnection();

            log.debug("AutoCommit WithTransactionRollback: {}", connection.getAutoCommit());

            PreparedStatement statement = connection.prepareStatement("update region.jc_region set region_name = ? where region_id = ?");
            statement.setString(1, region.getName());
            statement.setLong(2, region.getId());
            final int updateCount = statement.executeUpdate();
            log.debug("UpdateCount WithTransactionRollback: {}", updateCount);
            statement.close();
            transaction.rollback();
            connection.close();
        } catch (Exception ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            try {
                transaction.rollback();
            } catch (SystemException e) {
                e.printStackTrace();
            }
            throw new BusinessException(ex.getMessage());
        }
    }

    public void updateRegionWithNoTransactionCommit(Region region) throws BusinessException {
        try {

            Connection connection = dataSource.getConnection();

            log.debug("AutoCommit WithNoTransactionCommit before transaction begin: {}", connection.getAutoCommit());
            transaction.begin();
            log.debug("AutoCommit WithNoTransactionCommit after transaction begin: {}", connection.getAutoCommit());

            PreparedStatement statement = connection.prepareStatement("update region.jc_region set region_name = ? where region_id = ?");
            statement.setString(1, region.getName());
            statement.setLong(2, region.getId());
            final int updateCount = statement.executeUpdate();
            log.debug("UpdateCount WithNoTransactionCommit: {}", updateCount);
            statement.close();
            transaction.commit();
            connection.close();
        } catch (Exception ex) {
            log.error("{}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
            try {
                transaction.rollback();
            } catch (SystemException e) {
                e.printStackTrace();
            }
            throw new BusinessException(ex.getMessage());
        }
    }

}
