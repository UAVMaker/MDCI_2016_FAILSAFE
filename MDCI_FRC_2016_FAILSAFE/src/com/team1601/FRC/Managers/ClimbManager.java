package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.Constants.SoftwareConstants;
import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * 
 * @author Naresh
 * The Climb Manager responsible for controlling all of the Climb System Functions.
 */
public class ClimbManager implements Manager{
private static ClimbManager instance = new ClimbManager();
HardwareCentral hardware = HardwareCentral.getInstance();
DoubleSolenoid climber;
CANTalon climb;
public static ClimbManager getInstance(){
	return ClimbManager.instance;
}
private ClimbManager(){ // Exist to prevent use anywhere else.
	}
@Override
public void initialize() {
	climber = hardware.climbActuator;
	climb = hardware.climb;
	
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

