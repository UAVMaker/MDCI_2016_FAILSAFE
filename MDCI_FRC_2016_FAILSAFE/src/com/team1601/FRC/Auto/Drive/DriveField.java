package com.team1601.FRC.Auto.Drive;

import com.team1601.FRC_2016.Utilities.Functions;

public class DriveField {
	
	public void fieldDrive(double linear, double left, double right){
		double straight = linear;
		double leftArc = left* .5;
		double rightArc = right*.5;
		
double leftVal = straight+leftArc;
double rightVal = straight+rightArc;
leftVal = Functions.limitValue(leftVal);
rightVal = Functions.limitValue(rightVal);

//drive.setLeftRightMotorOutputs(leftVal, rightVal);
	}
}
