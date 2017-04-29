package com.test.robot;

import com.app.robot.CircleBlock;
import com.app.robot.Robot;

import junit.framework.TestCase;

public class CircleBlockTest extends TestCase {

	public CircleBlockTest(String testName) {
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
		CircleBlock ThisBlock = new CircleBlock(ThisRobot, false);

		assertEquals(ThisRobot, ThisBlock.Holder);
		assertEquals(false, ThisBlock.IsPartofCircle);
	}

	public void testFailedConstructor() {
		Robot ThisRobot = new Robot();
		CircleBlock ThisBlock = new CircleBlock(null, false);

		assertNotSame(ThisRobot, ThisBlock.Holder);
		assertNotSame(true, ThisBlock.IsPartofCircle);
	}
}