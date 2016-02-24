package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class ShooterBase {
	//Create Objects in Subsystem
	Talon flywheel;
	Solenoid shooter;

	boolean shooterActuationOn;
	private static ShooterBase INSTANCE = new ShooterBase();
	//Returns Instance of this class to the outsiders
	public static ShooterBase getInstance() {
		if(INSTANCE == null)
			INSTANCE = new ShooterBase();
		return INSTANCE;
	}
	//Private creation of class
	private ShooterBase() {
		flywheel = new Talon(HardwareConstants.FLY_WHEEL);
		
		shooter = new Solenoid(HardwareConstants.PCM, HardwareConstants.SHOOTER_SOLENOID);
	}


	//shoot sequence
	public void shootAuto() {
		shooterActuator(false);
		flywheel(SoftwareConstants.SHOOTER_SPEED);
		Timer.delay(1);
		shooterActuator(true);
		Timer.delay(.25);
		shooterActuator(false);

	}
	
	// index the boulder
	public void indexBall() {
		flywheel.set(SoftwareConstants.INDEX_SPEED);

	}
	//turn of flywheels
	public void flywheelOff() {
		flywheel(SoftwareConstants.INDEX_SPEED);
	}
	//sets the position of the actuator
	public void shooterActuator(boolean forward) {
		shooterActuationOn = forward;
		shooter.set(shooterActuationOn);
	}
	// set shooter speed
	public void flywheel(double speed) {
		flywheel.set(speed);
	}

}
