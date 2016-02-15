package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ClimbBase {
	DoubleSolenoid climber;
	private static final ClimbBase INSTANCE = new ClimbBase();
	
	public static ClimbBase getInstance(){
		return INSTANCE;
	}
private ClimbBase(){
	climber = new DoubleSolenoid(HardwareConstants.PCM,
			HardwareConstants.CLIMBER_FORWARD,
			HardwareConstants.CLIMBER_REVERSE);
}
public void acutuateUP(){
	climber.set(Value.kForward);
}
public void acutateDown(){
	climber.set(Value.kReverse);
}
public void actuatorOff(){
	climber.set(Value.kOff);
}

}
