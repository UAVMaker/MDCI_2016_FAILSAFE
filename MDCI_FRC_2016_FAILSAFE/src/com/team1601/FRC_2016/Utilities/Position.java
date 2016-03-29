package com.team1601.FRC_2016.Utilities;

public class Position {
double x, y;

public Position(){
	this.x =0;
	this.y =0;
}

public void updatePosition(double distance, double angle){
	this.x += distance * Math.cos(Math.toRadians(angle));
	this.y += distance * Math.sin(Math.toRadians(angle));
}

public double getX(){
	return x;
}

public double getY(){
	return y;
}

public void reset(){
	this.x = 0;
	this.y = 0;
}
}
