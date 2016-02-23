package com.team1601.FRC_2016.HardwareModule;


import edu.wpi.first.wpilibj.CANTalon;

public class ArmBase {
	CANTalon arm;
	private static final ArmBase INSTANCE = new ArmBase(); 
	
	public static ArmBase getInstance(){
		return INSTANCE;
	}
	
	private ArmBase(){
		// create new arm object
	 arm = new CANTalon(HardwareConstants.SHOOTER_ARM);
	 // Enables the Talon to stop in position once the input  == 0
	 arm.enableBrakeMode(true);
	 //Sets the rate at which the voltage increases per second (3 Volts/sec)
	 arm.setVoltageRampRate(SoftwareConstants.ARM_VOLTAGE_RAMP_RATE);
	}
	/*
	 * Arm goes up
	 */
	public void armUP(){
		arm.set(SoftwareConstants.ARM_SPEED);
	}
	/*
	 * Arm goes down
	 */
	public void armDown(){
		arm.set(-SoftwareConstants.ARM_SPEED);
	}
	/*
	 * Arm is set to zero indication to brake
	 */
	public void armOff(){
		arm.set(0);
	}
}
