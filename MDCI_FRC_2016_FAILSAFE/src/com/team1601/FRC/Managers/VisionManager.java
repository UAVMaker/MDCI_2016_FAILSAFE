package com.team1601.FRC.Managers;

import com.team1601.FRC_2016.Interface.Manager;

/**
 * 
 * @author Naresh
 * The Vision Manager responsible for controlling all of the Vision Functions.
 */
public class VisionManager implements Manager{
private static VisionManager manager = new VisionManager();
public static VisionManager getInstance(){
	return manager;
}
private VisionManager(){
	// Exist to prevent use anywhere else.
}
@Override
public void initialize() {
	// TODO Auto-generated method stub
	
}
}
