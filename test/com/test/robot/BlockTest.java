package com.test.robot;

import com.app.robot.Block;
import com.app.robot.Robot;

import junit.framework.TestCase;

public class BlockTest extends TestCase {

	public BlockTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConstructor() {
		Robot ThisRobot = new Robot();
		Block ThisBlock = new Block(ThisRobot);
		assertEquals(ThisRobot, ThisBlock.Holder);
	}

	public void testFailedConstructor() {
		Robot ThisRobot = new Robot();
		Block ThisBlock = new Block(null);
		assertNotSame(ThisRobot, ThisBlock.Holder);
	}
}
