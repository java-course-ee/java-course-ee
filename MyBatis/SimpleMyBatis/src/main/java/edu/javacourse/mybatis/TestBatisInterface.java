package edu.javacourse.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Intern on 27.10.14.
 */
public class TestBatisInterface {

    public static void main(String[] args) throws IOException {
        String resource = "Configuration.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = sqlSessionFactory.openSession();
        RegionDao dao = session.getMapper(RegionDao.class);
        System.out.println("RegionDao class: " + dao.getClass().getCanonicalName());

        Region region = new Region();
        region.setRegionName("12345");
        dao.insertRegion(region);
        session.commit();

        System.out.println("RegionId: " + region.getRegionId());

        findAndGet(dao);

        region.setRegionName("54321");
        dao.updateRegion(region);
        session.commit();

        findAndGet(dao);

        dao.deleteRegionById(region.getRegionId());
        session.commit();

        findAndGet(dao);
    }

    private static void findAndGet(RegionDao dao) {
        List<Region> list = dao.selectAllRegions();

        System.out.println("=======================");
        System.out.println("List of region: " + list.size());
        for (Region r : list) {
            System.out.println("RegionID:" + r.getRegionId());
            System.out.println("RegionName:" + r.getRegionName());
        }
        System.out.println("=======================");
    }

}
