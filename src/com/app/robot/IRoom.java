package com.app.robot;

import java.awt.Point;

public interface IRoom {
	public Point getStartPosition();

	public boolean contains(Point position);
}
