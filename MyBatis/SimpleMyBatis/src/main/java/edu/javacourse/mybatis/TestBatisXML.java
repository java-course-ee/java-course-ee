package edu.javacourse.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestBatisXML {

    public static void main(String[] args) throws IOException {
        String resource = "Configuration.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Region region = new Region();
            region.setRegionName("12345");

            session.insert("ibatis.RegionMapper.insertRegion", region);
            session.commit();

            System.out.println("Region ID: " + region.getRegionId());

            findAndGet(session);

            region.setRegionName("54321");
            session.update("ibatis.RegionMapper.updateRegion", region);
            session.commit();
            findAndGet(session);

            session.delete("ibatis.RegionMapper.deleteRegion", region.getRegionId());
            session.commit();
            findAndGet(session);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    private static void findAndGet(SqlSession session) {
        List<Region> list = (List) session.selectList("ibatis.RegionMapper.selectAllRegion");

        System.out.println("=======================");
        System.out.println("List of region: " + list.size());
        for (Region r : list) {
            System.out.println("RegionID:" + r.getRegionId());
            System.out.println("RegionName:" + r.getRegionName());
        }
        System.out.println("=======================");
    }
}
