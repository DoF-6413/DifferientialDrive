// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrain;

import java.sql.Driver;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
 

public class ILoveDriveTrain extends SubsystemBase {
  /** Creates a new stinkydrivetrain. */
  private final CANSparkMax leftMotor, leftMotor2, rightMotor, rightMotor2;
  private final RelativeEncoder leftEncoder, rightEncoder;
  private final DifferentialDrive iLoveDiffDrive;
  private final MotorControllerGroup leftMotors, rightMotors;

  public ILoveDriveTrain() {
leftMotor = new CANSparkMax(DriveTrain.leftMotorCanId, MotorType.kBrushless);
leftMotor2 = new CANSparkMax(DriveTrain.leftMotor2CanId, MotorType.kBrushless);
rightMotor = new CANSparkMax(DriveTrain.rightMotorCanId, MotorType.kBrushless);
rightMotor2 = new CANSparkMax(DriveTrain.rightMotor2CanId, MotorType.kBrushless);
leftMotor.setIdleMode(IdleMode.kBrake);
leftMotor2.setIdleMode(IdleMode.kBrake);
rightMotor.setIdleMode(IdleMode.kBrake);
rightMotor2.setIdleMode(IdleMode.kBrake);
leftMotor.setInverted(DriveTrain.leftMotorsInverted);
leftMotor2.setInverted(DriveTrain.leftMotorsInverted);
rightMotor.setInverted(DriveTrain.rightMotorsInverted);
rightMotor2.setInverted(DriveTrain.rightMotorsInverted);
leftMotors = new MotorControllerGroup(leftMotor, leftMotor2);
rightMotors = new MotorControllerGroup(rightMotor, rightMotor2);
leftEncoder = leftMotor.getEncoder();
rightEncoder = rightMotor.getEncoder();
iLoveDiffDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void DiffDrive(double leftMotorValue, double rightMotorValue){
    iLoveDiffDrive.arcadeDrive(leftMotorValue, rightMotorValue);
  }
}
