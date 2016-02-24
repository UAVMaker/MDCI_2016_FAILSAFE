package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ClimbBase {
	// Create the DoubleSolenoid controlling the Climber
	DoubleSolenoid climber;
	CANTalon climb;
	/*
	 * Create a private instance of this class to know that it will only be
	 * created once.
	 */
	private static  ClimbBase INSTANCE = new ClimbBase();

	// returns the instance of this class to the outside world.
	public static ClimbBase getInstance() {
		if(INSTANCE == null)
			INSTANCE = new ClimbBase();
		return INSTANCE;
	}

	// Private Instance for single creation
	private ClimbBase() {
		climber = new DoubleSolenoid(HardwareConstants.PCM, HardwareConstants.CLIMBER_FORWARD,
				HardwareConstants.CLIMBER_REVERSE);
		climb = new CANTalon(HardwareConstants.CLIMBER_MOTOR_PORT);
	}

	// Actuator goes up
	public void acutuateUP() {
		climber.set(Value.kForward);
	}

	// Actuator goes down
	public void acutateDown() {
		climber.set(Value.kReverse);
	}

	// Actuator is turned off
	public void actuatorOff() {
		climber.set(Value.kOff);
	}

	public void climberArmUP(){
		climb.set(SoftwareConstants.CLIMB_MOTOR_SPEED);
	}
	public void climberArmDOWN(){
		climb.set(-SoftwareConstants.CLIMB_MOTOR_SPEED);
	}
	public void climberArmSTOP(){
		climb.set(0);
	}
}
