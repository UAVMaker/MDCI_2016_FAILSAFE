package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.HardwareModule.ShooterBase;
import com.team1601.FRC_2016.Utilities.LogitechController;

public class ShooterControl extends Thread{

	ShooterBase shooter = ShooterBase.getInstance();
	LogitechController joystick = JoystickManager.getInstance().getOperatorJoystick();
	public void run(){
		if(joystick.getLT())shooter.shootAuto();
		else if(joystick.getRT())shooter.indexBall();
		else shooter.flywheelOff();
		
		
	}
}
