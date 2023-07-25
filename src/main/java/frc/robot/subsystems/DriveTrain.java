// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax LeftMotor1;
  private CANSparkMax LeftMotor2;
  private CANSparkMax RightMotor3;
  private CANSparkMax RightMotor4;
  private final MotorControllerGroup MotorGroup1;
  private final MotorControllerGroup MotorGroup2;
  private final DifferentialDrive    DiffDrive;
  public DriveTrain() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
