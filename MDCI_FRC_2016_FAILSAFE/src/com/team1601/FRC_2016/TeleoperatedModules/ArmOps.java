package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC.Managers.ArmManager;
import com.team1601.FRC.Managers.JoystickManager;
import com.team1601.FRC_2016.Interface.TeleopMode;
import com.team1601.FRC_2016.Utilities.Logitech;

public class ArmOps implements TeleopMode{
private static ArmOps instance;
ArmManager arm;
Logitech operatorJoystick;
public static ArmOps getInstance(){
	if(instance == null){
		instance = new ArmOps();
	}
	return instance;
}

private ArmOps(){
	arm = ArmManager.getInstance();
	operatorJoystick = JoystickManager.getInstance().getOperatorJoystick();
}
	@Override
	public void calculate() {
		if(operatorJoystick.getA()){
			arm.armUP();
		}else if(operatorJoystick.getX()){
			arm.armDown();
		}else{ arm.armOff();}
		
	}

	@Override
	public void disable() {
		arm.armOff();
		
	}

}
