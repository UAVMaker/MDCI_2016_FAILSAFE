package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.Compressor;

public class Pneumatics{
	Compressor compressor;
	private static Pneumatics INSTANCE = new Pneumatics();
	public static Pneumatics getInstance(){
		if(INSTANCE == null)
			INSTANCE = new Pneumatics();
		return INSTANCE;
	}
	private Pneumatics(){
		compressor = new Compressor(HardwareConstants.PCM);
	}
	
	public void start(){
		compressor.start();
	}
	public void stop(){
		compressor.stop();
	}
	
	
}
