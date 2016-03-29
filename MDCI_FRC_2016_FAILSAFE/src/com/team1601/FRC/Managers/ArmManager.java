package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.Constants.SoftwareConstants;
import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 * 
 * @author Naresh
 * The Arm Manger responsible for controlling all of the Arm Functions.
 */
public class ArmManager implements Manager{
	HardwareCentral hardware = HardwareCentral.getInstance();
	CANTalon arm;
	private double LowerLimit =0;
	private double UpperLimit = 0;
	private static ArmManager manager;
	public static ArmManager getInstance(){
	return manager;
	}
	private ArmManager(){
		// Exist to prevent use anywhere else.
	}
	@Override
	public void initialize() {
		arm = hardware.arm;
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
