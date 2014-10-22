package edu.javacourse.spring.dao;

import edu.javacourse.spring.model.Region;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Author: Georgy Gobozov
 * Date: 21.07.13
 */
public class JdbcRegionDao implements RegionDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public Integer createRegion(Region region) {
        String sql = "INSERT INTO jc_region (region_name) VALUES (?)";
        int regionId = 0;
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            //PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, region.getName());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                regionId = rs.getInt(1);
            }

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return regionId;
    }

    @Override
    public void deleteRegion(Region region) {
        String sql = "DELETE FROM jc_region where region_id = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, region.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Region getRegionByName(String name) {
        String sql = "SELECT * FROM jc_region where region_name=?";
        Region region = null;
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                region = new Region();
                region.setId(rs.getInt("region_id"));
                region.setName(rs.getString("region_name"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return region;
    }
}
