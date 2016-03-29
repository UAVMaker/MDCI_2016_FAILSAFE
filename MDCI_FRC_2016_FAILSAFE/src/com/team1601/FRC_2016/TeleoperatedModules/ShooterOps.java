package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC.Managers.JoystickManager;
import com.team1601.FRC.Managers.ShooterManager;
import com.team1601.FRC_2016.Interface.TeleopMode;
import com.team1601.FRC_2016.Utilities.Logitech;

public class ShooterOps implements TeleopMode{
	ShooterManager manager;
	JoystickManager joystickSystem;
	Logitech operatorJoystick;
	
	private static ShooterOps instance;
	public static ShooterOps getInstance(){
		if(instance == null){
			instance = new ShooterOps();
		}
		return instance;
	}
	private ShooterOps(){
		joystickSystem = JoystickManager.getInstance();
		operatorJoystick = joystickSystem.getOperatorJoystick();
	}
	@Override
	public void calculate() {
		// TODO Insert Actions
//		Shooter shooter = Shooter.getInstance();
//		Logitech joystick = Joysticks.getInstance().getOperatorJoystick();
//		public void run(){
//			if(joystick.getLT())shooter.shootAuto();
//			else if(joystick.getRT())shooter.indexBall();
//			else shooter.flywheelOff();
	}

	@Override
	public void disable() {
		// TODO Insert Disabled code
		
	}

}
