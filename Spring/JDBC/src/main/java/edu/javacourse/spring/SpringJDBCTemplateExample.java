package edu.javacourse.spring;

import edu.javacourse.spring.model.City;
import edu.javacourse.spring.model.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringJDBCTemplateExample {

    private static final Logger log = LoggerFactory.getLogger(SpringJDBCTemplateExample.class);

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);

        queryForSimpleObject(jdbc);
        queryForComplexObject(jdbc);
        insertNewRegion(jdbc);
        queryForListComplexObjects(jdbc);
        batchUpdate(jdbc);
        insertConstructor(jdbc);
        manyToOne(jdbc);
        oneToManyMultipleQueries(jdbc);
    }

    private static void separator(String title) {
        log.debug("\r\n\r\n\r\n\r\n");
        log.debug("========== {} ==========", title);
        log.debug("");
    }

    private static void queryForSimpleObject(JdbcTemplate jdbc) {
        separator("queryForSimpleObject");
        int countOfRegion = jdbc.queryForObject("select count(*) from region.jc_region where region_name = ?", new String[]{"Moscow"}, Integer.class);
        log.debug("Region count: {}", countOfRegion);

        String regionName = jdbc.queryForObject("select region_name from region.jc_region where region_id = ? and region_name = ?", new Object[]{1L, "Moscow"}, String.class);
        log.debug("Region Name: {}", regionName);
    }

    private static void queryForComplexObject(JdbcTemplate jdbc) {
        separator("queryForComplexObject");
        Region region = jdbc.queryForObject("select region_id, region_name from region.jc_region where region_id = ? and region_name = ?", new Object[]{1L, "Moscow"}, new RowMapper<Region>() {
            @Override
            public Region mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Region(resultSet.getInt("region_id"), resultSet.getString("region_name"));
            }
        });
        log.debug("Region = {}", region);
    }

    private static void insertNewRegion(JdbcTemplate jdbc) {
        separator("insertNewRegion");
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory("insert into region.jc_region (region_name) values (?)");
        creatorFactory.setGeneratedKeysColumnNames("region_id");
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        PreparedStatementCreator preparedStatementCreator = creatorFactory.newPreparedStatementCreator(new String[]{"HMAO"});
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int insertCount = jdbc.update(preparedStatementCreator, keyHolder);
        log.debug("Insert count: {}", insertCount);
        log.debug("New Region's id: {}", keyHolder.getKey().longValue());
    }

    private static void queryForListComplexObjects(JdbcTemplate jdbc) {
        separator("queryForListComplexObjects");
        List<Region> list = jdbc.query("SELECT region_id, region_name FROM region.jc_region",
                new RowMapper<Region>() {
                    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Region region = new Region();
                        region.setRegionId(rs.getInt("region_id"));
                        region.setRegionName(rs.getString("region_name"));
                        return region;
                    }
                });
        for (Region r : list) {
            log.debug("Region: id: {}, name: {}", r.getRegionId(), r.getRegionName());
        }
    }

    private static void batchUpdate(JdbcTemplate jdbc) {
        separator("batchUpdate");
        final List<Region> regions = new ArrayList<Region>();
        regions.add(new Region("test1"));
        regions.add(new Region("test2"));
        regions.add(new Region("test3"));
        regions.add(new Region("test4"));

        int[] ints = jdbc.batchUpdate("insert into region.jc_region (region_name) values (?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, regions.get(i).getRegionName());
            }

            @Override
            public int getBatchSize() {
                return regions.size();
            }
        });

        for (int i : ints) {
            log.debug("Inserted: {} records", i);
        }
    }

    private static void insertConstructor(JdbcTemplate jdbc) {
        separator("insertConstructor");
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbc).withSchemaName("region").withTableName("jc_region").usingGeneratedKeyColumns("region_id");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("region_name", "new region name");
        Number number = insertActor.executeAndReturnKey(parameters);
        log.debug("Inserted region id: {}", number.longValue());
    }

    private static void manyToOne(JdbcTemplate jdbc) {
        separator("manyToOne");

        List<City> cityList = jdbc.query("select c.city_id as c_id, c.city_name as c_name, c.region_id as r_id, r.region_name as r_name from region.jc_city c inner join region.jc_region r on c.region_id=r.region_id", new RowMapper<City>() {
            @Override
            public City mapRow(ResultSet rs, int i) throws SQLException {
                Region region = new Region(rs.getInt("r_id"), rs.getString("r_name"));
                City city = new City(rs.getInt("c_id"), rs.getString("c_name"), region);
                return city;
            }
        });

        for (City city : cityList) {
            log.debug("City: {}, region: {}", city, city.getRegion());
        }
    }

    private static void oneToManyMultipleQueries(JdbcTemplate jdbc) {
        separator("oneToManyMultipleQueries");

        List<Region> regionList = jdbc.query("select r.region_id, r.region_name from region.jc_region r ", new RowMapper<Region>() {
            @Override
            public Region mapRow(ResultSet rs, int i) throws SQLException {
                return new Region(rs.getInt("region_id"), rs.getString("region_name"));
            }
        });
        for (final Region region : regionList) {
            List<City> cities = jdbc.query("select c.city_id, c.city_name from region.jc_city c where c.region_id = ?", new Integer[]{region.getRegionId()}, new RowMapper<City>() {
                @Override
                public City mapRow(ResultSet rs, int i) throws SQLException {
                    return new City(rs.getInt("city_id"), rs.getString("city_name"), region);
                }
            });
            region.setCities(cities);
        }

        for (Region region : regionList) {
            log.debug("Region: {}", region);
        }
    }

}
