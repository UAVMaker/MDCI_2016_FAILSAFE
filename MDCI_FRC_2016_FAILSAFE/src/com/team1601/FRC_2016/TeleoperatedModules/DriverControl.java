package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC_2016.HardwareModule.DriveBase;
import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.Utilities.Logitech;
import com.team1601.FRC_2016.Utilities.Toggle;

public class DriverControl extends Thread {

	DriveBase drive = DriveBase.getInstance();
	double leftSide, rightSide;
	Logitech joystick = JoystickManager.getInstance().getDriverJoystick();
	Toggle orientation = new Toggle();

	public void run() {
		leftSide = joystick.getYAxis();
		rightSide = joystick.getRightYAxis();
		if (orientation.update(joystick.getA())) {
			leftSide = -leftSide;
			rightSide = -rightSide;
		}
		drive.tankDrive(leftSide, rightSide);
	}
}
