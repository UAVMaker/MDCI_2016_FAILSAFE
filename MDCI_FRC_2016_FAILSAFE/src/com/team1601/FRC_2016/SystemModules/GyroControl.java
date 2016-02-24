package com.team1601.FRC_2016.SystemModules;

import com.team1601.FRC_2016.HardwareModule.Sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroControl extends Thread{
	Sensors sensors = Sensors.getInstance();
public void run(){
	SmartDashboard.putNumber("Gyro Angle", sensors.getGyroAngle());
}
}
