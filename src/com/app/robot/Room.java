package com.app.robot;

import java.awt.Point;

public class Room implements IRoom {
	private int _Width;
	private int _Height;
	private Block[][] _Blocks;
	private Robot _ThisRobot;
	private Point _StartingPosition;

	public Room(int Width, int Height, Robot ThisRobot, Point StartingPosition) {
		_Width = Width < 3 ? 3 : Width;
		_Height = Height < 3 ? 3 : Height;
		_ThisRobot = ThisRobot;

		_Blocks = new Block[_Width][_Height];

		for (int x = 0; x < _Width; x++) {
			for (int y = 0; y < _Height; y++) {
				_Blocks[x][y] = new Block(null);
			}
		}

		StartingPosition.x = StartingPosition.x > _Width || StartingPosition.x < 0 ? 0 : StartingPosition.x;
		StartingPosition.y = StartingPosition.y > _Height || StartingPosition.y < 0 ? 0 : StartingPosition.y;

		StartingPosition.x = StartingPosition.x > 0 ? StartingPosition.x - 1 : 0;
		StartingPosition.y = StartingPosition.y > 0 ? StartingPosition.y - 1 : 0;

		_StartingPosition = StartingPosition;

		ThisRobot.setPosition(_StartingPosition);

		_Blocks[ThisRobot.getPosition().x][ThisRobot.getPosition().y].Holder = _ThisRobot;
	}

	public Robot getRobot() {
		return _ThisRobot;
	}

	private void MoveRobot(Point OldPosition, Point NewPosition) {
		_Blocks[NewPosition.x][NewPosition.y].Holder = _Blocks[OldPosition.x][OldPosition.y].Holder;
		_Blocks[OldPosition.x][OldPosition.y].Holder = null;

		_ThisRobot.setPosition(NewPosition);
	}

	public void MoveForward() {
		if (this.CanMove()) {
			Point next = this.NextBlock();
			this.MoveRobot(_ThisRobot.getPosition(), next);

			_ThisRobot.setPosition(next);
		}
	}

	public void TurnLeft() {
		this.TurnDirection(3);
		// this.MoveForward();
	}

	public void TurnRight() {
		this.TurnDirection(1);
		// this.MoveForward();
	}

	private void TurnDirection(int Steps) {
		_ThisRobot.setDirection((_ThisRobot.getDirection() + Steps) % 4);
	}

	public boolean contains(Point position) {
		return (position.x >= 0 && position.y >= 0 && position.x < _Width && position.y < _Height
				&& _Blocks[position.x][position.y].Holder == null);
	}

	private boolean CanMove() {
		Point next = this.NextBlock();
		return this.contains(next);
	}

	private Point NextBlock() {
		switch (_ThisRobot.getDirection()) {
		case Robot.NORTH:
			return new Point(_ThisRobot.getPosition().x, _ThisRobot.getPosition().y - 1);
		case Robot.EAST:
			return new Point(_ThisRobot.getPosition().x + 1, _ThisRobot.getPosition().y);
		case Robot.SOUTH:
			return new Point(_ThisRobot.getPosition().x, _ThisRobot.getPosition().y + 1);
		case Robot.WEST:
			return new Point(_ThisRobot.getPosition().x - 1, _ThisRobot.getPosition().y);
		default:
			return new Point(_ThisRobot.getPosition().x, _ThisRobot.getPosition().y);
		}
	}

	public Point getStartPosition() {
		return _StartingPosition;
	}
}