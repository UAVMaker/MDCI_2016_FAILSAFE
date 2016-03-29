package com.team1601.FRC_2016.HardwareModule;

import com.team1601.FRC_2016.Constants.HardwareConstants;
import com.team1601.FRC_2016.Utilities.Logitech;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;

public class HardwareCentral {
private static HardwareCentral hub = new HardwareCentral();
public static boolean initialized = false;

public static HardwareCentral getInstance(){
	return hub;
}
public CANTalon 	   leftFront, 
					   rightDrive, 
					   leftSlaveDrive,
					   rightSlaveDrive,
					   arm,
					   climb;
public Logitech        driverJoystick, 
					   operatorJoystick;
public  DoubleSolenoid climbActuator;
public  Solenoid       shooterActuator;
public  Talon          shooterWheels;
public  Compressor     compressor;
public AnalogGyro 	gyro;
public AnalogInput maxbotixSonar;
public ADXRS450_Gyro rioSPIGyro;
public ADXL362 rioSPIAccelerometer;
public BuiltInAccelerometer rioAccelerometer;
private HardwareCentral(){
	leftFront = new CANTalon(HardwareConstants.LEFT_FRONT_DRIVE); 
	   rightDrive = new CANTalon(HardwareConstants.RIGHT_FRONT_DRIVE);
	   leftSlaveDrive = new CANTalon(HardwareConstants.LEFT_REAR_DRIVE);
	   rightSlaveDrive = new CANTalon(HardwareConstants.RIGHT_REAR_DRIVE);
	   arm = new CANTalon(HardwareConstants.SHOOTER_ARM);
	   climb = new CANTalon(HardwareConstants.CLIMBER_MOTOR_PORT);
	   
	   driverJoystick = new Logitech(HardwareConstants.DRIVER_JOYSTICK);
	   operatorJoystick = new Logitech(HardwareConstants.OPERATOR_JOYSTICK);
	   
	   climbActuator = new DoubleSolenoid(HardwareConstants.PCM, HardwareConstants.CLIMBER_FORWARD,HardwareConstants.CLIMBER_REVERSE);
	   
	   shooterActuator = new Solenoid(HardwareConstants.PCM, HardwareConstants.SHOOTER_SOLENOID);
	   shooterWheels = new Talon(HardwareConstants.FLY_WHEEL);
	   compressor = new Compressor(HardwareConstants.PCM);
	   gyro = new AnalogGyro(HardwareConstants.GYRO_PORT);
	   maxbotixSonar = new AnalogInput(HardwareConstants.SONAR_PORT);
	   rioSPIGyro = new ADXRS450_Gyro();
	   rioSPIAccelerometer = new ADXL362(Range.k16G);
	   rioAccelerometer = new BuiltInAccelerometer();
	   
	   initialized = true;
}
}
