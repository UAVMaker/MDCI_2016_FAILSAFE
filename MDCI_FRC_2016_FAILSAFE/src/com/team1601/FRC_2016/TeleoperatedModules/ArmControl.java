package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC_2016.HardwareModule.ArmBase;
import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.Utilities.Logitech;

public class ArmControl extends Thread {
	Logitech joystick = JoystickManager.getInstance().getOperatorJoystick();
	ArmBase arm = ArmBase.getInstance();

	public void run() {
		if (joystick.getA())
			arm.armUP();
		else if (joystick.getX())
			arm.armDown();
		else
			arm.armOff();
	}
}
