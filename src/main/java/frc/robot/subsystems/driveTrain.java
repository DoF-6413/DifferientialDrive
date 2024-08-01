// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.DriveTrainConstants;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase {
  CANSparkMax frontLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax backRightMotor;
  RelativeEncoder leftEncoder;
  RelativeEncoder rightEncoder;
  DifferentialDrive diffDrive;
  MotorControllerGroup leftMotorGroup;
  MotorControllerGroup rightMotorGroup;
  /** Creates a new driveTrain. */
  public driveTrain() {
    frontLeftMotor = new CANSparkMax(DriveTrainConstants.FLMotorID, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(DriveTrainConstants.FRMotorID, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(DriveTrainConstants.BLMotorID, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(DriveTrainConstants.BRMotorID, MotorType.kBrushless);
    leftEncoder = frontLeftMotor.getEncoder();
    rightEncoder = frontRightMotor.getEncoder();
    leftMotorGroup = new MotorControllerGroup(frontLeftMotor,backLeftMotor);
    rightMotorGroup = new MotorControllerGroup(frontRightMotor,backRightMotor);
    diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
    leftEncoder.setPositionConversionFactor(DriveTrainConstants.ticksToInches);
    rightEncoder.setPositionConversionFactor(DriveTrainConstants.ticksToInches);
    frontLeftMotor.setInverted(DriveTrainConstants.leftInversion);
    backLeftMotor.setInverted(DriveTrainConstants.leftInversion);
    frontRightMotor.setInverted(DriveTrainConstants.rightInversion);
    backRightMotor.setInverted(DriveTrainConstants.rightInversion);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double driveSpeed, double rotationSpeed){
    diffDrive.arcadeDrive(driveSpeed, rotationSpeed);
  }

  public double getEncoderDistance () {
    return (leftEncoder.getPosition() + rightEncoder.getPosition()) / 2;
  }

  public void resetEncoderPosition () {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }
}
