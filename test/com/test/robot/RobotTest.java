package com.test.robot;

import java.awt.Point;

import com.app.robot.Robot;

import junit.framework.TestCase;

public class RobotTest extends TestCase {

	Robot ThisRobot = null;

	public RobotTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();

		ThisRobot = new Robot();
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		ThisRobot = null;
	}

	public void testDirection() {
		ThisRobot.setDirection(Robot.EAST);
		assertEquals(Robot.EAST, ThisRobot.getDirection());
	}

	public void testFailedDirection() {
		ThisRobot.setDirection(Robot.EAST);
		assertNotSame(Robot.NORTH, ThisRobot.getDirection());
	}

	public void testPosition() {
		Point position = new Point(1, 1);
		ThisRobot.setPosition(position);
		assertEquals(position, ThisRobot.getPosition());
	}

	public void testFailedPosition() {
		Point position = new Point(1, 1);
		ThisRobot.setPosition(new Point(2, 2));
		assertNotSame(position, ThisRobot.getPosition());
	}

	public void testDisplayDirection() {
		ThisRobot.setDirection(Robot.EAST);
		assertEquals("E", ThisRobot.getDisplayDirection("E"));
	}

	public void testFailedDisplayDirection() {
		ThisRobot.setDirection(Robot.EAST);
		assertNotSame("W", ThisRobot.getDisplayDirection("E"));
	}

	public void testDisplayPosition() {
		Point position = new Point(1, 1);
		ThisRobot.setPosition(position);
		assertEquals(new Point(1, 1), ThisRobot.getPosition());
	}

	public void testDisplayFailedPosition() {
		ThisRobot.setPosition(new Point(2, 2));
		assertNotSame(new Point(1, 1), ThisRobot.getPosition());
	}
}