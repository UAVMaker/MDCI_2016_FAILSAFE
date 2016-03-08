package com.team1601.FRC_2016.TestModules;

import com.team1601.FRC_2016.HardwareModule.DriveBase;
import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.HardwareModule.Sensors;
import com.team1601.FRC_2016.Utilities.Logitech;

public class GyroTurn extends Thread {
	DriveBase drive = DriveBase.getInstance();
	Logitech joystick = JoystickManager.getInstance().getOperatorJoystick();
	Sensors sensors = Sensors.getInstance();
	double testKp = 0.3;
	double setAngle = 0;
	double tolerance = 3;

	public void run() {
		double angle = sensors.getGyroAngle();
		double error = setAngle - angle;
		if (joystick.getA()) {
			drive.drive(0, testKp * error);
			if (Math.abs(error) < tolerance) {
				drive.drive(0, 0);
			}
		}
	}
}
