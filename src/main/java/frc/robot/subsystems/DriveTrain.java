// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public CANSparkMax frontLeftMotor;
  public CANSparkMax backLeftMotor;
  public CANSparkMax frontRightMotor;
  public CANSparkMax backRightMotor; 
  public RelativeEncoder leftEncoder;
  public RelativeEncoder rightEncoder; 
  public DifferentialDrive difDrive; 
  public DriveTrain() {
    frontLeftMotor = new CANSparkMax(DriveConstants.frontLeftID, MotorType.kBrushless); 
    backLeftMotor = new CANSparkMax(DriveConstants.backLeftID, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(DriveConstants.frontRightID, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(DriveConstants.backRightID, MotorType.kBrushless); 
    leftEncoder = frontLeftMotor.getEncoder(); 
    rightEncoder = frontRightMotor.getEncoder();
    difDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor); 
    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor); 
    frontLeftMotor.setInverted(DriveConstants.leftInverted);
    frontRightMotor.setInverted(DriveConstants.rightInverted); 
    frontLeftMotor.setIdleMode(IdleMode.kBrake); 
    frontRightMotor.setIdleMode(IdleMode.kBrake); 
    leftEncoder.setPositionConversionFactor(DriveConstants.ticksToInches);
    rightEncoder.setPositionConversionFactor(DriveConstants.ticksToInches); 
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double leftStick, double rightStick) {
    frontLeftMotor.set(leftStick);
    frontRightMotor.set(rightStick); 
  }
  public void setBrake(boolean enable) {
    if (enable) {
      frontLeftMotor.setIdleMode(IdleMode.kBrake);
      frontRightMotor.setIdleMode(IdleMode.kBrake); 
    } else {
      frontLeftMotor.setIdleMode(IdleMode.kCoast);
      frontRightMotor.setIdleMode(IdleMode.kCoast); 
    }
  }
  public double distance() {
    return (leftEncoder.getPosition() + rightEncoder.getPosition()) / 2; 
  }
  public void resetPosition() {
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0); 
  }
}
