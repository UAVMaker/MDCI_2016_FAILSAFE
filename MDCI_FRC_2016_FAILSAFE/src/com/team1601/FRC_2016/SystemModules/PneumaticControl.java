package com.team1601.FRC_2016.SystemModules;

import com.team1601.FRC_2016.HardwareModule.JoystickManager;
import com.team1601.FRC_2016.HardwareModule.Pneumatics;
import com.team1601.FRC_2016.Utilities.LogitechController;
import com.team1601.FRC_2016.Utilities.Toggle;

public class PneumaticControl extends Thread {
	Pneumatics pneu = Pneumatics.getInstance();
	LogitechController joystick = JoystickManager.getInstance().getOperatorJoystick();
	Toggle toggle = new Toggle();
	boolean running = true;

	public void run() {
		if (running) {
			boolean comp = toggle.update(joystick.getRB());
			if (comp) {
				pneu.start();
			} else {
				pneu.stop();
			}
		}
	}
}
