
package com.team1601.FRC_2016;

import java.util.Vector;

import com.team1601.FRC_2016.AutonomousModules.DriveStraightAuto;
import com.team1601.FRC_2016.SystemModules.PneumaticControl;
import com.team1601.FRC_2016.TeleoperatedModules.ArmControl;
import com.team1601.FRC_2016.TeleoperatedModules.Climber;
import com.team1601.FRC_2016.TeleoperatedModules.DriverControl;
import com.team1601.FRC_2016.TeleoperatedModules.ShooterControl;
import com.team1601.FRC_2016.TestModules.ShooterTest;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    Vector<Thread> systemThreads, autoThreads, testThreads,teleopThreads;
   
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        
        systemThreads = new Vector<Thread>();
        systemThreads.addElement(new PneumaticControl());
        
        autoThreads = new Vector<Thread>();
        autoThreads.addElement(new DriveStraightAuto());
        testThreads = new Vector<Thread>();
        testThreads.addElement(new ShooterTest());
        
        teleopThreads = new Vector<Thread>();
        teleopThreads.addElement(new ArmControl());
        teleopThreads.addElement(new DriverControl());
        teleopThreads.addElement(new ShooterControl());
        teleopThreads.addElement(new Climber());
        
    }
    

    public void autonomousInit(){
    	startThreads(systemThreads);
    	startThreads(autoThreads);
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
    	startThreads(systemThreads);
    	startThreads(teleopThreads);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testInit() {
    	startThreads(testThreads);
    }
    public void disabledInit(){
    	
    }
    public void disabledPeriodic(){
    	stopThreads(systemThreads);
    	stopThreads(autoThreads);
    	stopThreads(teleopThreads);
    	stopThreads(testThreads);
    }
    
    public void startThreads(Vector<Thread> threads){
    	for(int i =0; i<=threads.size(); i++){
    		((Thread)threads.elementAt(i)).start();
    	}
    }
    
    public void stopThreads(Vector<Thread> threads){
    	for(int i =0; i<=threads.size(); i++){
    		((Thread)threads.elementAt(i)).interrupt();
    	}
    }
    

    
}
