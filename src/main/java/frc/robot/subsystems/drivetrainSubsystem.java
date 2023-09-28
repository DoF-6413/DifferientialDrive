// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants.Drivetrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

public class drivetrainSubsystem extends SubsystemBase {
  /** Creates a new drivetrainSubsystem. */
  private final CANSparkMax leftMotor, leftMotor2, rightMotor, rightMotor2;
  private final RelativeEncoder leftEncoder, rightEncoder;
  private final DifferentialDrive diffDrive;
  private final MotorControllerGroup leftMotors, rightMotors;

  public drivetrainSubsystem() {
    leftMotor = new CANSparkMax(Drivetrain.leftMotorID, MotorType.kBrushless);
    leftMotor2 = new CANSparkMax(Drivetrain.leftMotor2ID, MotorType.kBrushless);
    rightMotor = new CANSparkMax(Drivetrain.rightMotorID, MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(Drivetrain.rightMotor2ID, MotorType.kBrushless);
    leftMotor.setIdleMode(IdleMode.kBrake);
    leftMotor2.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);
    rightMotor2.setIdleMode(IdleMode.kBrake);
    leftMotor.setInverted(false);
    leftMotor2.setInverted(false);
    rightMotor.setInverted(true);
    rightMotor2.setInverted(true);
    leftMotors = new MotorControllerGroup(leftMotor, leftMotor2);
    rightMotors = new MotorControllerGroup(rightMotor, rightMotor2);
    leftEncoder = leftMotor.getEncoder();
    rightEncoder = rightMotor.getEncoder();
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void diffDrive(double leftMotorValue, double rightMotorValue){
    diffDrive.arcadeDrive(leftMotorValue, rightMotorValue);
  }
}
