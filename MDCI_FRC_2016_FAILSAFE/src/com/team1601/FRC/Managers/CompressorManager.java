package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;

import edu.wpi.first.wpilibj.Compressor;

public class CompressorManager implements Manager{
	HardwareCentral hardware = HardwareCentral.getInstance();
	Compressor comp;
	private static CompressorManager manager = new CompressorManager();
	public static CompressorManager getInstance(){
		return manager;
	}
	private CompressorManager(){
		// Exist to prevent use anywhere else.
	}
	@Override
	public void initialize() {
		comp = hardware.compressor;
		// TODO Auto-generated method stub
		
	}
	
	public void start(){
		comp.start();
	}
	public void stop(){
		comp.stop();
	}

}
