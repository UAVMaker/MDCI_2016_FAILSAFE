
package com.team1601.FRC_2016;

import com.team1601.FRC.Managers.ArmManager;
import com.team1601.FRC.Managers.ClimbManager;
import com.team1601.FRC.Managers.CompressorManager;
import com.team1601.FRC.Managers.DriveManager;
import com.team1601.FRC.Managers.GyroManager;
import com.team1601.FRC.Managers.JoystickManager;
import com.team1601.FRC.Managers.ShooterManager;
import com.team1601.FRC.Managers.SonarManager;
import com.team1601.FRC.Managers.SystemsManager;
import com.team1601.FRC.Managers.VisionManager;
import com.team1601.FRC_2016.HardwareModule.HardwareCentral;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser chooser;
	HardwareCentral hardware;
	ArmManager arm;
	ClimbManager climb;
	CompressorManager compressor;
	DriveManager drive;
	GyroManager gyro;
	JoystickManager joysticks;
	ShooterManager shooter;
	SonarManager sonar;
	SystemsManager system;
	VisionManager vision;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
		if(HardwareCentral.initialized){hardware = HardwareCentral.getInstance();
		
		arm = ArmManager.getInstance();
		arm.initialize();
		climb = ClimbManager.getInstance();
		climb.initialize();
		compressor = CompressorManager.getInstance();
		compressor.initialize();
		drive = DriveManager.getInstance();
		drive.initialize();
		gyro = GyroManager.getInstance();
		gyro.initialize();
		joysticks = JoystickManager.getInstance();
		joysticks.initialize();
		shooter = ShooterManager.getInstance();
		shooter.initialize();
		sonar = SonarManager.getInstance();
		sonar.initialize();
		system = SystemsManager.getInstance();
		system.read();
		vision = VisionManager.getInstance();
		vision.initialize();
		}else{
			System.out.println("Quantum your missing a PARTICLE");
		}
	}

	public void autonomousInit() {
		
	}
	

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopInit() {
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testInit() {

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {

	}



}
