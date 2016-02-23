package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ClimbBase {
	// Create the DoubleSolenoid controlling the Climber
	DoubleSolenoid climber;
	
	/*
	 * Create a private instance of this class to know that it will only be
	 * created once.
	 */
	private static final ClimbBase INSTANCE = new ClimbBase();

	// returns the instance of this class to the outside world.
	public static ClimbBase getInstance() {
		return INSTANCE;
	}

	// Private Instance for single creation
	private ClimbBase() {
		climber = new DoubleSolenoid(HardwareConstants.PCM, HardwareConstants.CLIMBER_FORWARD,
				HardwareConstants.CLIMBER_REVERSE);
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

}
