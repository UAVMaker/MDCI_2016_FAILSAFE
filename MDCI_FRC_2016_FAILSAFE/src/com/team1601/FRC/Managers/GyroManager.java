package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.HardwareModule.HardwareCentral;
import com.team1601.FRC_2016.Interface.Manager;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;

public class GyroManager implements Manager{
private static GyroManager manager = new GyroManager();
HardwareCentral hardware = HardwareCentral.getInstance();
AnalogGyro baseGyro;
ADXRS450_Gyro rioGyro;
public static GyroManager getInstance(){
	return manager;
}
	@Override
	public void initialize() {
		baseGyro = hardware.gyro;
		rioGyro = hardware.rioSPIGyro;
	}

	public double getBaseGyroAngle(){
		return baseGyro.getAngle();
	}
	public double getRIOGyroAngle(){
		return rioGyro.getAngle();
	}
	public void calilbrateBaseGyro(){
		baseGyro.calibrate();
	}
	public void calibrateRIOGyro(){
		rioGyro.calibrate();
	}

}
