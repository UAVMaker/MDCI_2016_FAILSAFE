package com.team1601.FRC_2016.TestModules;

import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.HardwareModule.ShooterBase;
import com.team1601.FRC_2016.Utilities.Logitech;

public class ShooterTest extends Thread{
	ShooterBase shooter = ShooterBase.getInstance();
	Logitech joystick = JoystickManager.getInstance().getOperatorJoystick();
	public void run(){
		
		shooter.shootAuto();
	}
}
