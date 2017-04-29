package com.test.robot;

import java.awt.Point;

import com.app.robot.CircleRoom;
import com.app.robot.Robot;
import junit.framework.TestCase;

public class CircleRoomTest extends TestCase {
	Robot ThisRobot = null;
	CircleRoom ThisRoom = null;

	public CircleRoomTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();

		ThisRobot = new Robot();
		ThisRoom = new CircleRoom(5, ThisRobot, new Point(5, 5));
	}

	protected void tearDown() throws Exception {
		super.tearDown();

		ThisRobot = null;
	}

	public void testGetRobot() {
		assertEquals(ThisRobot, ThisRoom.getRobot());
	}

	public void testFailedGetRobot() {
		assertNotSame(null, ThisRoom.getRobot());
	}

	public void testgetStartPosition() {
		assertEquals(new Point(4, 4), ThisRoom.getStartPosition());
	}

	public void testFailedgetStartPosition() {
		assertNotSame(new Point(1, 1), ThisRoom.getStartPosition());
	}

	public void testcontains() {
		assertEquals(true, ThisRoom.contains(new Point(5, 5)));
	}

	public void testFailedcontains() {
		assertNotSame(true, ThisRoom.contains(new Point(15, 15)));
	}

	public void testTurnRight() {
		ThisRoom.TurnRight();
		assertEquals(new Point(4, 4), ThisRoom.getRobot().getPosition());
	}

	public void testFailedTurnRight() {
		ThisRoom.TurnRight();
		assertNotSame(new Point(1, 1), ThisRoom.getRobot().getPosition());
	}

	public void testTurnLeft() {
		ThisRoom.TurnLeft();
		assertEquals(new Point(4, 4), ThisRoom.getRobot().getPosition());
	}

	public void testFailedTurnLeft() {
		ThisRoom.TurnLeft();
		assertNotSame(new Point(5, 5), ThisRoom.getRobot().getPosition());
	}

	public void testMoveForward() {
		ThisRoom.MoveForward();
		assertEquals(new Point(4, 3), ThisRoom.getRobot().getPosition());
	}

	public void testFailedMoveForward() {
		ThisRoom.TurnRight();
		ThisRoom.MoveForward();
		assertNotSame(new Point(2, 2), ThisRoom.getRobot().getPosition());
	}
}