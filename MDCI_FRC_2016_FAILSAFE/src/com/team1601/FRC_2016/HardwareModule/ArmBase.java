package com.team1601.FRC_2016.HardwareModule;


import edu.wpi.first.wpilibj.CANTalon;

public class ArmBase {
	CANTalon arm;
	private static final ArmBase INSTANCE = new ArmBase(); 
	
	public static ArmBase getInstance(){
		return INSTANCE;
	}
	
	private ArmBase(){
	 arm = new CANTalon(HardwareConstants.SHOOTER_ARM);
	}
	public void armUP(){
		arm.set(SoftwareConstants.ARM_SPEED);
	}
	public void armDown(){
		arm.set(-SoftwareConstants.ARM_SPEED);
	}
	public void armOff(){
		arm.set(0);
	}
}
