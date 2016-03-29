package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.Constants.SoftwareConstants;
import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * 
 * @author Naresh
 * The Shooter Manager responsible for controlling all of the Shooter Functions.
 */
public class ShooterManager implements Manager{
private static ShooterManager manager = new ShooterManager();
HardwareCentral hardware = HardwareCentral.getInstance();
Talon flywheel;
Solenoid shooter;
public static ShooterManager getInstance(){
	return manager;
}
private ShooterManager(){
	// Exist to prevent use anywhere else.
}
@Override
public void initialize() {
	flywheel = hardware.shooterWheels;
	shooter = hardware.shooterActuator;
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
	shooter.set(forward);
}
// set shooter speed
public void flywheel(double speed) {
	flywheel.set(speed);
}

}
