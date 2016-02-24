package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

public class Sensors {
private static final Sensors INSTANCE = new Sensors();
private AnalogGyro gyro;
private AnalogInput sonar;
public static Sensors getInstance(){
	return INSTANCE;
}

private Sensors(){
	gyro = new AnalogGyro(HardwareConstants.GYRO_PORT);
	sonar = new AnalogInput(HardwareConstants.SONAR_PORT);
}

public double getGyroAngle(){
	return gyro.getAngle();
}

public double sonarToInches(){
	double analogVal = sonar.getVoltage();
	 double mm = analogVal*5;      //Takes bit count and converts it to mm
	 double inches = mm/25.4;
	return inches;
}
}
