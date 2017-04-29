package com.app.robot;

import java.awt.Point;

public class Robot {

	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;

	private Point _Position;
	private int _Direction = 0;

	public Robot() {
		this._Direction = NORTH;
		this._Position = new Point(0, 0);
	}

	public int getDirection() {
		return this._Direction;
	}

	public void setDirection(int Direction) {
		this._Direction = Direction;
	}

	public Point getPosition() {
		return _Position;
	}

	public void setPosition(Point Position) {
		_Position = Position;
	}

	public Point getDisplayPosition() {
		return new Point(_Position.x + 1, _Position.y + 1);
	}

	public String getDisplayDirection(String LanguageCode) {
		if (LanguageCode.equals("SV")) {
			switch (_Direction) {
			case NORTH:
				return "N";
			case EAST:
				return "Ö";
			case SOUTH:
				return "S";
			case WEST:
				return "V";
			default:
				return "unknown";
			}
		} else {
			switch (_Direction) {
			case NORTH:
				return "N";
			case EAST:
				return "E";
			case SOUTH:
				return "S";
			case WEST:
				return "W";
			default:
				return "unknown";
			}
		}
	}

}
