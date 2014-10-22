package edu.javacourse.spring.test;

import edu.javacourse.spring.bean.RegionManager;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springExample.xml"})
public class SimpleTest extends TestCase {


    @Autowired
    RegionManager manager;


    @Test
    public void testRegionManager() throws Exception {
        assertNotNull(manager);
        manager.createRegion("SPB");
    }


}
