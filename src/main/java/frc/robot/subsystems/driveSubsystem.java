// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class driveSubsystem extends SubsystemBase {
  private final CANSparkMax LeftMotor1;
  private final CANSparkMax LeftMotor2;
  private final CANSparkMax RightMotor1;
  private final CANSparkMax RightMotor2;
  private final RelativeEncoder RightEncoder;
  private final RelativeEncoder LeftEncoder;
  private final MotorControllerGroup LeftMotorControllerGroup;
  private final MotorControllerGroup RightMotorControllerGroup;
  private final DifferentialDrive DiffDrive;
  /** Creates a new driveSubsystem. */
  public driveSubsystem() {
    RightMotor1 = new CANSparkMax (DriveTrainConstants.RightMotor1CANID, MotorType.kBrushless);
    RightMotor2 = new CANSparkMax (DriveTrainConstants.RightMotor2CANID, MotorType.kBrushless);
    LeftMotor1 = new CANSparkMax (DriveTrainConstants.LeftMotor1CANID, MotorType.kBrushless);
    LeftMotor2 = new CANSparkMax (DriveTrainConstants.LeftMotor2CANID, MotorType.kBrushless);
    LeftEncoder = LeftMotor1.getEncoder();
    RightEncoder = RightMotor1.getEncoder();
    LeftEncoder.setPositionConversionFactor(DriveTrainConstants.TicksToFeet);
    RightEncoder.setPositionConversionFactor(DriveTrainConstants.TicksToFeet);
    LeftMotorControllerGroup = new MotorControllerGroup(LeftMotor1, LeftMotor2);
    RightMotorControllerGroup  = new MotorControllerGroup(RightMotor1, RightMotor2);
    RightMotor1.setInverted(DriveTrainConstants.RightMotor1Inverted);
    RightMotor2.setInverted (DriveTrainConstants.RightMotor2Inverted);
    LeftMotor1.setInverted (DriveTrainConstants.LeftMotor1Inverted);
    LeftMotor2.setInverted(DriveTrainConstants.LeftMotor2Inverted);
    DiffDrive = new DifferentialDrive(LeftMotorControllerGroup, RightMotorControllerGroup);
  }
  public void diffDrive (double speed,double direction) {
    DiffDrive.arcadeDrive(speed, direction);
  }

  public double ReturnsLeftDistanceValue () {
    return LeftEncoder.getPosition();
  }

   public double ReturnsRightDistanceValue () {
    return RightEncoder.getPosition();
  }
  
  public void ResetDistance () {
    LeftEncoder.setPosition(0);
    RightEncoder.setPosition(0);
  }
  
  public double AverageDistance () {
    return (ReturnsLeftDistanceValue() + ReturnsRightDistanceValue())/2;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
