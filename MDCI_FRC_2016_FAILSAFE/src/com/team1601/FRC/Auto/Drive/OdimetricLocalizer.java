package com.team1601.FRC.Auto.Drive;

import com.team1601.FRC_2016.Constants.HardwareConstants;
import com.team1601.FRC_2016.Interface.Localizer;

import edu.wpi.first.wpilibj.Encoder;

public class OdimetricLocalizer extends Thread implements Localizer {
	private static final float PI = (float) Math.PI;
	private static final float TWO_PI = PI * 2.0f;
	private float mDistancePerCount;
	private float mRadiansPerCount;
	private float mX = 0.0f;
	private float mY = 0.0f;
	private float mHeading = 0.0f;
	private int mPeriod;
	private int mPreviousLeftCounts;
	private int mPreviousRightCounts;

	public OdimetricLocalizer() {

	}

	public synchronized void setPose(Pose pose) {
		mX = pose.x;
		mY = pose.y;
		mHeading = pose.heading;
	}

	public synchronized void setPose(float x, float y, float heading) {
		mX = x;
		mY = y;
		mHeading = heading;
	}

	public synchronized void setPosition(float x, float y) {
		mX = x;
		mY = y;
	}

	public synchronized void setHeading(float heading) {
		mHeading = heading;
	}

	public synchronized Pose getPose() {
		return new Pose(mX, mY, mHeading);
	}

	public double getLeftEncoderCounts(double encoderCounts) {
		return encoderCounts;
	}

	public double getRightEncoderCounts(double encoderCounts) {
		return encoderCounts;
	}

	public int getCountsPerRevolution() {
		return 360;
	}

	public double getDistancePerCount() {
		double distancePerCount = PI * HardwareConstants.WHEEL_DIAMETER / getCountsPerRevolution();
		return distancePerCount;
	}

	public double getDeltaDistance(double leftCounts, double rightCounts) {
		double deltaDistance = (leftCounts + rightCounts) / 2 * this.getDistancePerCount();
		return deltaDistance;
	}

	public double getCountsPerRotation(double trackWidth, int wheelDiameter) {
		double countsPerRotation = (trackWidth / wheelDiameter) * this.getCountsPerRevolution();
		return countsPerRotation;
	}

	public double getRadiansPerCount(double trackWidth, int wheelDiameter) {
		double radiansPerCount = PI * (wheelDiameter / trackWidth) / this.getCountsPerRevolution();
		return radiansPerCount;
	}

	public double getDeltaHeading(double leftCounts, double rightCounts, double trackWidth, int wheelDiameter) {
		double deltaHeading = (rightCounts - leftCounts) * this.getRadiansPerCount(trackWidth, wheelDiameter);
		return deltaHeading;
	}
	
	public double getDeltaX(double leftCounts, double rightCounts){
		double deltaX= this.getDeltaDistance(leftCounts, rightCounts)*Math.cos(mHeading);
		return deltaX;
	}
	public double getDeltaY(double leftCounts, double rightCounts){
		double deltaY= this.getDeltaDistance(leftCounts, rightCounts)*Math.sin(mHeading);
		return deltaY;
	}

	public void run() {

	}
}
