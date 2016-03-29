package com.team1601.FRC_2016.TeleoperatedModules;

import com.team1601.FRC.Managers.DriveManager;
import com.team1601.FRC.Managers.JoystickManager;
import com.team1601.FRC_2016.Interface.TeleopMode;
import com.team1601.FRC_2016.Utilities.Logitech;
import com.team1601.FRC_2016.Utilities.Toggle;

public class DriveOps implements TeleopMode{
	private static DriveOps instance;
	DriveManager drive;
	Logitech driverJoystick;
	Toggle orientation = new Toggle();
	boolean update;
	double leftArc, rightArc, linear;
	public static DriveOps getInstance(){
		if(instance == null){
			instance = new DriveOps();
		}
		return instance;
	}
	private DriveOps(){
		drive = DriveManager.getInstance();
		driverJoystick = JoystickManager.getInstance().getDriverJoystick();
	}
	@Override
	public void calculate() {
		update = orientation.update(driverJoystick.getA());
		
		
	}
	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}
}
