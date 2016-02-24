package com.team1601.FRC_2016.HardwareModule;

import com.team1601.FRC_2016.Utilities.Logitech;

public class JoystickManager {
Logitech[] joysticks;
Logitech joystick1, joystick2;
private static JoystickManager INSTANCE = new JoystickManager();

public static JoystickManager getInstance(){
	if(INSTANCE == null)
		INSTANCE = new JoystickManager();
	return INSTANCE;
}
private JoystickManager(){
	joysticks = new Logitech [2];
	joystick1 = joysticks[0];
	joystick2 = joysticks[1];
	
	joystick1.setDeadBand(HardwareConstants.JOYSTICK1_DEADBAND);
	joystick2.setDeadBand(HardwareConstants.JOYSTICK2_DEADBAND);
}
public Logitech getDriverJoystick(){
	return joystick1;
}

public Logitech getOperatorJoystick(){
	return joystick2;
}
}
