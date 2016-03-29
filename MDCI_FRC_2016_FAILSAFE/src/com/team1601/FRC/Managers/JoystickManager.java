package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.Constants.HardwareConstants;
import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;
import com.team1601.FRC_2016.Utilities.Logitech;

public class JoystickManager implements Manager{
private static JoystickManager manager = new JoystickManager();
Logitech driverJoystick, operatorJoystick;
HardwareCentral hardware = HardwareCentral.getInstance();
public static JoystickManager getInstance(){
	return manager;
}
private JoystickManager(){
	// Exist to prevent use anywhere else.
}
@Override
public void initialize() {
	driverJoystick = hardware.driverJoystick;
	operatorJoystick = hardware.operatorJoystick;
	
	driverJoystick.setDeadBand(HardwareConstants.JOYSTICK1_DEADBAND);
	operatorJoystick.setDeadBand(HardwareConstants.JOYSTICK2_DEADBAND);
	
}
public Logitech getDriverJoystick(){
	return driverJoystick;
}

public Logitech getOperatorJoystick(){
	return operatorJoystick;
}
}
