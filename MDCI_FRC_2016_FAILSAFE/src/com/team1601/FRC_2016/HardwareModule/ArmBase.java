package com.team1601.FRC_2016.HardwareModule;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

public class ArmBase {
	/**
	 * This class is to provide the essential functions of the ARM
	 * Attached to our Arm houses a potentiometer which we use to calculate the position
	 * Through the use of the CANTalon Position Mode and a couple PID Variables we can
	 * set the Arm to a specific position.
	 */
	CANTalon arm;
	private static ArmBase INSTANCE = new ArmBase(); 
	private double LowerLimit =0;
	private double UpperLimit = 0;
	public static ArmBase getInstance(){
		if(INSTANCE == null)
			INSTANCE = new ArmBase();
		return INSTANCE;
	}
	
	private ArmBase(){
		// create new arm object
	 arm = new CANTalon(HardwareConstants.SHOOTER_ARM);
	 // Enables the Talon to stop in position once the input  == 0
	 arm.enableBrakeMode(true);
	 //Sets the rate at which the voltage increases per second (3 Volts/sec)
	 arm.setVoltageRampRate(SoftwareConstants.ARM_VOLTAGE_RAMP_RATE);
	 arm.setFeedbackDevice(FeedbackDevice.AnalogPot);
	}
	
	public double getArmPostionFromPotiometer(){
		return arm.get();
	}
	public void setGroundPosition(double pos){
		LowerLimit = pos;
	}
	
	public void setUpperPosition(double pos){
		UpperLimit = pos;
	}
	
	public void autoArmUP(){
		if(this.getArmPostionFromPotiometer() != UpperLimit){
			arm.changeControlMode(TalonControlMode.Position);
			arm.set(UpperLimit);
		}
	}
	
	public void autoArmDown(){
		if(this.getArmPostionFromPotiometer() != LowerLimit){
			arm.changeControlMode(TalonControlMode.Position);
			arm.set(LowerLimit);
		}
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
