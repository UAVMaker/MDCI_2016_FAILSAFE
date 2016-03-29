package com.team1601.FRC_2016.Interface;

import com.team1601.FRC.Auto.Drive.Pose;

public interface Localizer {
public Pose getPose();
public void setPose(Pose pose);
public void setPosition(float x, float y);
public void setHeading(float heading);
}
