package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class ShooterBase {
	Talon flywheel;
	Compressor c;
	Solenoid shooter;

	boolean shooterActuationOn;
	private static final ShooterBase INSTANCE = new ShooterBase();

	public static ShooterBase getInstance() {
		return INSTANCE;
	}

	private ShooterBase() {
		flywheel = new Talon(HardwareConstants.FLY_WHEEL);
		c = new Compressor(HardwareConstants.COMPRESSOR);
		shooter = new Solenoid(HardwareConstants.PCM, HardwareConstants.SHOOTER_SOLENOID);
	}

	public void compressorOperation(boolean value) {
		c.setClosedLoopControl(value);
	}

	public void shoot() {
		shooterActuator(false);
		flywheel(SoftwareConstants.SHOOTER_SPEED);
		Timer.delay(.75);
		shooterActuator(true);
		Timer.delay(.25);
		shooterActuator(false);

	}

	public void indexBall() {
		shooterActuator(false);

	}

	public void flywhellOff() {
		flywheel(SoftwareConstants.INDEX_SPEED);
	}

	public void shooterActuator(boolean forward) {
		shooterActuationOn = forward;
		shooter.set(shooterActuationOn);
	}

	public void flywheel(double speed) {
		flywheel.set(speed);
	}

}
