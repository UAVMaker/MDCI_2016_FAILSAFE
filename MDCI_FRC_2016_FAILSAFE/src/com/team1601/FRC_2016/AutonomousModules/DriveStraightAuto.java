package com.team1601.FRC_2016.AutonomousModules;

import com.team1601.FRC_2016.HardwareModule.DriveBase;

public class DriveStraightAuto extends Thread{
DriveBase drive = DriveBase.getInstance();

public void run(){
	drive.tankDrive(1, 1);
}
}
