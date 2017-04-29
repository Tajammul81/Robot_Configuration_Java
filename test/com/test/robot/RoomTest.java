package com.test.robot;

import java.awt.Point;

import com.app.robot.Robot;
import com.app.robot.Room;

import junit.framework.TestCase;

public class RoomTest extends TestCase {

	Robot ThisRobot = null;
	Room ThisRoom = null;

	public RoomTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();

		ThisRobot = new Robot();
		ThisRoom = new Room(5, 5, ThisRobot, new Point(0, 0));
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
		assertEquals(new Point(0, 0), ThisRoom.getStartPosition());
	}

	public void testFailedgetStartPosition() {
		assertNotSame(new Point(1, 1), ThisRoom.getStartPosition());
	}

	public void testcontains() {
		assertEquals(true, ThisRoom.contains(new Point(3, 3)));
	}

	public void testFailedcontains() {
		assertNotSame(true, ThisRoom.contains(new Point(7, 7)));
	}

	public void testTurnRight() {
		ThisRoom.TurnRight();
		assertEquals(new Point(0, 0), ThisRoom.getRobot().getPosition());
	}

	public void testFailedTurnRight() {
		ThisRoom.TurnRight();
		assertNotSame(new Point(1, 1), ThisRoom.getRobot().getPosition());
	}

	public void testTurnLeft() {
		ThisRoom.TurnRight();
		ThisRoom.TurnRight();
		ThisRoom.TurnLeft();
		assertEquals(new Point(0, 0), ThisRoom.getRobot().getPosition());
	}

	public void testFailedTurnLeft() {
		ThisRoom.TurnRight();
		ThisRoom.TurnRight();
		ThisRoom.TurnLeft();
		assertNotSame(new Point(2, 3), ThisRoom.getRobot().getPosition());
	}

	public void testMoveForward() {
		ThisRoom.TurnRight();
		ThisRoom.MoveForward();
		assertEquals(new Point(1, 0), ThisRoom.getRobot().getPosition());
	}

	public void testFailedMoveForward() {
		ThisRoom.TurnRight();
		ThisRoom.MoveForward();
		assertNotSame(new Point(2, 2), ThisRoom.getRobot().getPosition());
	}
}
