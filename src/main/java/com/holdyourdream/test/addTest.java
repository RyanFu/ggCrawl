package com.holdyourdream.test;

import junit.framework.TestCase;

public class addTest extends TestCase {
	com.holdyourdream.test.add add=new com.holdyourdream.test.add();
	public void testAdd1() {
		//fail("Not yet implemented");
		assertEquals(3,add.add1(1));
	}

}
