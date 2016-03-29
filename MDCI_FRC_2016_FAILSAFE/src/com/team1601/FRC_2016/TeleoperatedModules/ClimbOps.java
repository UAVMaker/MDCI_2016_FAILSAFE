package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC.Managers.ClimbManager;
import com.team1601.FRC.Managers.JoystickManager;
import com.team1601.FRC_2016.Interface.TeleopMode;
import com.team1601.FRC_2016.Utilities.Logitech;

public class ClimbOps implements TeleopMode{
	ClimbManager climbSystem;
	JoystickManager joystickSystem;
	Logitech operatorJoystick;
	
	private static ClimbOps instance;
	public static ClimbOps getInstance(){
		if(instance == null){
			instance = new ClimbOps();
		}
		return instance;
	}
	
	private ClimbOps(){
		climbSystem = ClimbManager.getInstance();
		joystickSystem = JoystickManager.getInstance();
		operatorJoystick = joystickSystem.getOperatorJoystick();
	}
	@Override
	public void calculate() {
		if(operatorJoystick.getLT()){
			climbSystem.climberArmUP();
			climbSystem.acutuateUP();
		}else if(operatorJoystick.getRT()){
			climbSystem.climberArmDOWN();
			climbSystem.acutateDown();
		}else{
			climbSystem.actuatorOff();
			climbSystem.climberArmSTOP();
		}
		
	}

	@Override
	public void disable() {
		climbSystem.actuatorOff();
		climbSystem.climberArmSTOP();
		
	}

}
