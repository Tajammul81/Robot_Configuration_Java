package com.app.robot;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		try {
			//Room ThisRoom = new Room(5, 5, new Robot(), new Point(1, 2));

			 CircleRoom ThisRoom = new CircleRoom(5, new Robot(), new Point(5, 5));

			System.out.println("Select your preferred Language. ENG for English / SV for Swedish");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String LanguageCode = br.readLine().trim().toUpperCase();
			if (LanguageCode.equals("ENG") || LanguageCode.equals("SV")) {
				System.out.println("you have chosen " + LanguageCode);

			} else {
				System.out.println("Please next time choose either Eng or Sv as a Language");
				System.exit(0);
			}
			System.out.println("Please enter direction command in " + LanguageCode + " to move the robot");
			br = new BufferedReader(new InputStreamReader(System.in));

			String Commands = br.readLine();

			System.out.println("X : " + ThisRoom.getRobot().getDisplayPosition().x + ", Y : "
					+ ThisRoom.getRobot().getDisplayPosition().y + ", Direction : "
					+ ThisRoom.getRobot().getDisplayDirection(LanguageCode));

			for (char SingleCommand : Commands.toUpperCase().toCharArray()) {
				if (LanguageCode.equals("SV")) {
					switch (SingleCommand) {
					case 'V':
						ThisRoom.TurnLeft();
						break;
					case 'H':
						ThisRoom.TurnRight();
						break;
					case 'G':
						ThisRoom.MoveForward();
						break;
					}
				} else {
					switch (SingleCommand) {
					case 'L':
						ThisRoom.TurnLeft();
						break;
					case 'R':
						ThisRoom.TurnRight();
						break;
					case 'F':
						ThisRoom.MoveForward();
						break;
					}
				}

				System.out.println("X : " + ThisRoom.getRobot().getDisplayPosition().x + ", Y : "
						+ ThisRoom.getRobot().getDisplayPosition().y + ", Direction : "
						+ ThisRoom.getRobot().getDisplayDirection(LanguageCode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
