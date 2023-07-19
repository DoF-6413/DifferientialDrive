// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveSubsystem extends SubsystemBase {
  private final CANSparkMax LeftMotor1;
  private final CANSparkMax LeftMotor2;
  private final CANSparkMax RightMotor1;
  private final CANSparkMax RightMotor2;
  private final MotorControllerGroup LeftMotorControllerGroup;
  private final MotorControllerGroup RightMotorControllerGroup;
  private final DifferentialDrive DiffDrive;
  /** Creates a new driveSubsystem. */
  public driveSubsystem() {
    RightMotor1 = new CANSparkMax (4, MotorType.kBrushless);
    RightMotor2 = new CANSparkMax (5, MotorType.kBrushless);
    LeftMotor1 = new CANSparkMax (2, MotorType.kBrushless);
    LeftMotor2 = new CANSparkMax (3, MotorType.kBrushless);
    LeftMotorControllerGroup = new MotorControllerGroup(LeftMotor1, LeftMotor2);
    RightMotorControllerGroup  = new MotorControllerGroup(RightMotor1, RightMotor2);
    RightMotor1.setInverted(true);
    RightMotor2.setInverted(true);
    LeftMotor1.setInverted(false);
    LeftMotor2.setInverted(false);
    DiffDrive = new DifferentialDrive(LeftMotorControllerGroup, RightMotorControllerGroup);
  }
  public void diffDrive (double speed,double direction) {
    DiffDrive.arcadeDrive(speed, direction);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
