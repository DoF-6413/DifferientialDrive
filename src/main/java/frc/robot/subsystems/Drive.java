// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  public static CANSparkMax motorSystem1;
  public static CANSparkMax motorSystem2;
  public static CANSparkMax motorSystem3;
  public static CANSparkMax motorSystem4;
  public static RelativeEncoder leftcounter;
  public static RelativeEncoder rightcounter;
  public static DifferentialDrive DiffDr;
  /** Creates a new Drive. */
  public Drive() {
    motorSystem1 = new CANSparkMax(DriveConstants.motorSystemID1, MotorType.kBrushless);
    motorSystem2 = new CANSparkMax(DriveConstants.motorSystemID2, MotorType.kBrushless);
    motorSystem3 = new CANSparkMax(DriveConstants.motorSystemID3, MotorType.kBrushless);
    motorSystem4 = new CANSparkMax(DriveConstants.motorSystemID4, MotorType.kBrushless);
    motorSystem1.setIdleMode(IdleMode.kBrake);
    motorSystem2.setIdleMode(IdleMode.kBrake);
    motorSystem3.setIdleMode(IdleMode.kBrake);
    motorSystem4.setIdleMode(IdleMode.kBrake);
    motorSystem1.follow(motorSystem2);
    motorSystem3.follow(motorSystem4);
    motorSystem2.setInverted(DriveConstants.motorSystem2IsInverted);
    motorSystem4.setInverted(DriveConstants.motorSystem4IsInverted);
    leftcounter = motorSystem4.getEncoder();
    rightcounter = motorSystem2.getEncoder();
    leftcounter.setPositionConversionFactor(DriveConstants.conversionfactor);
    rightcounter.setPositionConversionFactor(DriveConstants.conversionfactor);
    DiffDr = new DifferentialDrive(motorSystem4,motorSystem2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double drivestick, double turningstick) {
    DiffDr.arcadeDrive(drivestick, turningstick);
  }
  public void resetpose() {
    leftcounter.setPosition(0);
    rightcounter.setPosition(0);
  }
  public double getleftpose() {
    return leftcounter.getPosition();
  }
  public double getrightpose() {
    return rightcounter.getPosition();
  }
  public double getaveragepose() {
    return (getleftpose() + getrightpose()) / 2;
  }
  
}
