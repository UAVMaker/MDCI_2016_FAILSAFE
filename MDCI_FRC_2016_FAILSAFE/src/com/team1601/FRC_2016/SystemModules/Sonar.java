package com.team1601.FRC_2016.SystemModules;

import com.team1601.FRC_2016.HardwareModule.Sensors;

public class Sonar extends Thread{
Sensors sensor = Sensors.getInstance();
public void run(){
	sensor.sonarToInches();
}
}
