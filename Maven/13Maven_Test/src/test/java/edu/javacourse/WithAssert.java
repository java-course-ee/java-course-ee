package edu.javacourse;

import org.junit.Test;
import junit.framework.Assert;

public class WithAssert{
  
   
    @Test
	public void test1(){
		Assert.assertEquals(2, 2);
	}
	
	@Test
	public void test2(){
		Assert.assertEquals("Hello World", "Hello World");
	}
   

}