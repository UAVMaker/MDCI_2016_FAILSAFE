package com.team1601.FRC_2016.Utilities;

import edu.wpi.first.wpilibj.Joystick;

public class LogitechController {
		Joystick marco;

	public LogitechController(int port) {
		marco = new Joystick(port);
	}
	
	public boolean getX(){
		return marco.getRawButton(1);
	}
	
	public boolean getA(){
		return marco.getRawButton(2);
	}
	
	public boolean getB(){
		return marco.getRawButton(3);
	}
	
	public boolean getY(){
		return marco.getRawButton(4);
		
	}
	
	public boolean getLB(){
		return marco.getRawButton(5);
		
	}

	public boolean getRB(){
		return marco.getRawButton(6);
	}
	public boolean getLT(){
		return marco.getRawButton(7);
	}
	public boolean getRT(){
		return marco.getRawButton(8);
	}
	public double getXAxis(){
		return marco.getRawAxis(0);
	}
	public double getYAxis(){
		return -marco.getRawAxis(1);
	}
	public double getRightXAxis(){
		return marco.getRawAxis(2);
	}
	public double getRightYAxis(){
		return -marco.getRawAxis(3);
	}

}
