package com.app.robot;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class CircleRoom implements IRoom {

	private int _Radius;
	private CircleBlock[][] _Blocks;
	private Robot _ThisRobot;
	private Point _StartingPosition;

	public CircleRoom(int Radius, Robot ThisRobot, Point StartingPosition) {
		if (Radius < 3) {
			Radius = 3;
		}

		_Radius = Radius;
		_ThisRobot = ThisRobot;

		BufferedImage buffer = new BufferedImage(Radius * 2, Radius * 2, BufferedImage.TYPE_INT_RGB);
		Color c = Color.BLUE;
		Graphics2D context = buffer.createGraphics();
		context.setColor(c);
		context.fillOval(0, 0, Radius * 2, Radius * 2);

		_Blocks = new CircleBlock[Radius * 2][Radius * 2];
		for (int row = 0; row < Radius * 2; row++) {
			for (int col = 0; col < Radius * 2; col++) {
				_Blocks[row][col] = new CircleBlock(null, false);

				if (buffer.getRGB(col, row) == c.getRGB()) {
					_Blocks[row][col].IsPartofCircle = true;
				}

			}
		}

		StartingPosition.x = StartingPosition.x > Radius * 2 || StartingPosition.x < 0 ? 0 : StartingPosition.x;
		StartingPosition.y = StartingPosition.y > Radius * 2 || StartingPosition.y < 0 ? 0 : StartingPosition.y;

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
		return (position.x >= 0 && position.y >= 0 && position.x < _Radius * 2 && position.y < _Radius * 2
				&& _Blocks[position.x][position.y].IsPartofCircle && _Blocks[position.x][position.y].Holder == null);
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
