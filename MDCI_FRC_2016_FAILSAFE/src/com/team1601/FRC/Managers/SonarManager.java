package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;

import edu.wpi.first.wpilibj.AnalogInput;

public class SonarManager implements Manager{
private static SonarManager manager = new SonarManager();
HardwareCentral hardware = HardwareCentral.getInstance();
AnalogInput maxbotixSonar;
public static SonarManager getInstance(){
	return manager;
}
private SonarManager(){
	// Exist to prevent use anywhere else.
}
@Override
public void initialize() {
	maxbotixSonar = hardware.maxbotixSonar;
	
}
public double getSonarReadingInInches(){
	double analogVal = maxbotixSonar.getVoltage();
	 double mm = analogVal*5;      //Takes bit count and converts it to mm
	 double inches = mm/25.4;
	return inches;
}
}
