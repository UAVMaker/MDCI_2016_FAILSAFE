package com.team1601.FRC_2016.TestModules;

import com.team1601.FRC_2016.HardwareModule.ShooterBase;

public class ShooterTest extends Thread{
	ShooterBase shooter = ShooterBase.getInstance();
	public void run(){
		shooter.shootAuto();
	}
}
