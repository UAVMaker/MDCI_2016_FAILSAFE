package com.team1601.FRC_2016.HardwareModule;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class DriveBase {
	private CANTalon leftDrive, rightDrive, leftSlaveDrive, rightSlaveDrive;
	private RobotDrive drive;
	private double output;
	private int gear;
	private static final DriveBase INSTANCE = new DriveBase();

	public static DriveBase getInstance() {
		return INSTANCE;
	}

	private DriveBase() {
		leftDrive = new CANTalon(HardwareConstants.LEFT_FRONT_DRIVE);
		rightDrive = new CANTalon(HardwareConstants.RIGHT_FRONT_DRIVE);
		leftSlaveDrive = new CANTalon(HardwareConstants.LEFT_REAR_DRIVE);
		rightSlaveDrive = new CANTalon(HardwareConstants.RIGHT_REAR_DRIVE);
		leftSlaveDrive.changeControlMode(TalonControlMode.Follower);
		rightSlaveDrive.changeControlMode(TalonControlMode.Follower);
		leftSlaveDrive.set(HardwareConstants.LEFT_FRONT_DRIVE);
		rightSlaveDrive.set(HardwareConstants.RIGHT_FRONT_DRIVE);
		createRobotDrive();
	}

	private void createRobotDrive() {
		drive = new RobotDrive(rightDrive, rightSlaveDrive, leftDrive, leftSlaveDrive);
		drive.setInvertedMotor(MotorType.kFrontLeft, true);
		drive.setInvertedMotor(MotorType.kRearLeft, true);

	}

	private double transmission(double input) {
		double setpoint = Math.abs(input);
		double[] transmission = { .3, .5, .7, 1, 0 };
		if (setpoint > .1) {
			if (Math.abs(output) == transmission[gear]) {
				Timer.delay(1.5);
				gear++;
				if (gear >= 3)
					gear = 3;
			}
		} else {
			gear = 0;
		}
		output = setpoint * transmission[gear];
		if (input < 0) {
			output = -output;
		}
		return output;
	}

	public void tankDrive(double leftSide, double rightSide) {
		double left = transmission(leftSide);
		double right = transmission(rightSide);
		drive.tankDrive(left, right);
	}

}
