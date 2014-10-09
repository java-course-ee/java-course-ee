package edu.javacourse.spring;

import edu.javacourse.spring.model.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringExample {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springExample.xml"});

        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //test1(jdbc);
        //test2(jdbc);
        //test3(jdbc);
        //test4(jdbc);
        //test5(jdbc);
       // test6(jdbc);



    }

    private static void test6(JdbcTemplate jdbc) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbc).withTableName("jc_region");
        Region region = new Region(444, "44444444");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("region_id", region.getRegionId());
        parameters.put("region_name", region.getRegionName());
        insertActor.execute(parameters);
    }

    private static void test5(JdbcTemplate jdbc) {
        final List<Region> regions = new ArrayList<Region>();
        regions.add(new Region("test1"));
        regions.add(new Region("test2"));
        regions.add(new Region("test3"));
        regions.add(new Region("test4"));

        jdbc.batchUpdate("insert into jc_region (region_name) values (?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, regions.get(i).getRegionName());
            }

            @Override
            public int getBatchSize() {
               return regions.size();
            }
        });
    }


    private static void test4(JdbcTemplate jdbc) {
        // Пример вызова с созданием объектов
        List<Region> list = jdbc.query("SELECT * FROM jc_region",
                new RowMapper<Region>() {

                    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Region region = new Region();
                        region.setRegionId(rs.getInt("region_id"));
                        region.setRegionName(rs.getString("region_name"));
                        return region;
                    }
                });
        for(Region r : list) {
            System.out.println(r.getRegionName());
        }
    }

    private static void test3(JdbcTemplate jdbc) {
        // Пример вызова вставки
        jdbc.update("insert into jc_region (region_name) values (?)", "HMAO");
    }

    private static void test2(JdbcTemplate jdbc) {
        // Пример вызова возврата объекта с указанием массива параметров
        String regionName = jdbc.queryForObject("select region_name from jc_region where region_id = ? and region_name = ?", new Object[]{1L, "Moscow"}, String.class);
        Region region = jdbc.queryForObject("select * from jc_region where region_id = ? and region_name = ?", new Object[]{1L, "Moscow"}, new RowMapper<Region>() {
            @Override
            public Region mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Region(resultSet.getInt("region_id"), resultSet.getString("region_name"));
            }
        });
        System.out.println("NAME:" + regionName);
        System.out.println("region = " + region);
    }

    private static void test1(JdbcTemplate jdbc) {
        // Пример вызова возврата числа
        int countOfRegion = jdbc.queryForInt("select count(*) from jc_region where region_name = ?", "Moscow");
        System.out.println("COUNT:" + countOfRegion);
    }


}
