package com.team1601.FRC_2016.AutonomousGroups;

import com.team1601.FRC.Auto.Drive.DriveStraight;
import com.team1601.FRC_2016.AutonomousMode.Action;
import com.team1601.FRC_2016.AutonomousMode.AutonGroup;
import com.team1601.FRC_2016.AutonomousMode.AutonomousMode;

public class DriveForward implements AutonomousMode{

	@Override
	public Action[] getMode() {
		//Create AutonomousGroup
		AutonGroup group = new AutonGroup();
		
		group.addAction(new DriveStraight());
		
		
		return group.getAutoActionList();
	}

}
