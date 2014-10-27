package edu.javacourse.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Intern on 27.10.14.
 */
public interface RegionDao {

    @Select("select region_id, region_name from public.jc_region where region_id = #{id}")
    Region selectRegionById(Integer id);

    @Select("select region_id, region_name from public.jc_region")
    List<Region> selectAllRegions();

    @Insert("insert into public.jc_region (region_name) values (#{regionName})")
    @Options(useGeneratedKeys = true, keyProperty = "regionId")
    void insertRegion(Region region);

    @Update("update public.jc_region set region_name=#{regionName}")
    void updateRegion(Region region);

    @Delete("delete from public.jc_region where region_id=#{id}")
    void deleteRegionById(Integer id);

}
