package com.team1601.FRC_2016.HardwareModule;

import com.team1601.FRC_2016.Utilities.LogitechController;

public class JoystickManager {
LogitechController[] joysticks;
LogitechController joystick1, joystick2;
private static final JoystickManager INSTANCE = new JoystickManager();

public static JoystickManager getInstance(){
	return INSTANCE;
}
private JoystickManager(){
	joysticks = new LogitechController [2];
	joystick1 = joysticks[0];
	joystick2 = joysticks[1];
}
public LogitechController getDriverJoystick(){
	return joystick1;
}

public LogitechController getOperatorJoystick(){
	return joystick2;
}
}
