package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC_2016.HardwareModule.ClimbBase;
import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.Utilities.Logitech;

public class Climber extends Thread{
	ClimbBase climb = ClimbBase.getInstance();
	Logitech joystick = JoystickManager.getInstance().getOperatorJoystick();
	
	public void run(){
		if(joystick.getLT()){
			climb.climberArmUP();
			climb.acutuateUP();
		}else if(joystick.getRT()){
			climb.climberArmDOWN();
			climb.acutateDown();
		}else{
			climb.climberArmSTOP();
			climb.actuatorOff();
		}
	}
}
