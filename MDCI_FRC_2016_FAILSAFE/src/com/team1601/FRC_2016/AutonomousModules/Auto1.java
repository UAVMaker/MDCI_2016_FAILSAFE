package com.team1601.FRC_2016.AutonomousModules;

import com.team1601.FRC_2016.HardwareModule.ArmBase;
import com.team1601.FRC_2016.HardwareModule.DriveBase;
import com.team1601.FRC_2016.HardwareModule.ShooterBase;

import edu.wpi.first.wpilibj.Timer;

public class Auto1 extends Thread{
	DriveBase drive = DriveBase.getInstance();
	ArmBase arm = ArmBase.getInstance();
	ShooterBase shooter = ShooterBase.getInstance();
public void run(){
	drive.drive(1, 0);
	Timer.delay(2);
	drive.drive(0, 0);
	Timer.delay(.1);
	drive.drive(0, -.5);
	Timer.delay(.5);
	drive.drive(0, 0);
	Timer.delay(0);
	arm.armUP();
	Timer.delay(.5);
	arm.armOff();
	Timer.delay(.1);
	shooter.shootAuto();
	Timer.delay(4);
	shooter.flywheelOff();
	Timer.delay(.1);
	arm.armDown();
	Timer.delay(1);
	
	
	
}
}
