// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private CANSparkMax LeftMotor1;
  private CANSparkMax LeftMotor2;
  private CANSparkMax RightMotor3;
  private CANSparkMax RightMotor4;
  private final MotorControllerGroup MotorGroup1;
  private final MotorControllerGroup MotorGroup2;
  private final DifferentialDrive    DiffDrive;
  public DriveTrain(){
    LeftMotor1 = new CANSparkMax(DriveTrainConstants.LeftDriveMotor1, MotorType.kBrushless);
    LeftMotor2 = new CANSparkMax(DriveTrainConstants.LeftDriveMotor2, MotorType.kBrushless);
    RightMotor3 = new CANSparkMax(DriveTrainConstants.RightDriveMotor3, MotorType.kBrushless);
    RightMotor4 = new CANSparkMax(DriveTrainConstants.RightDriveMotor4, MotorType.kBrushless);
    LeftMotor1.setInverted(DriveTrainConstants.isLeftDriveMotor1Inverted);
    LeftMotor2.setInverted(DriveTrainConstants.isLeftDriveMotor2Inverted);
    RightMotor3.setInverted(DriveTrainConstants.isRightDriveMotor3Inverted);
    RightMotor4.setInverted(DriveTrainConstants.isRightDriveMotor4Inverted);
  MotorGroup1 = new MotorControllerGroup(LeftMotor1,LeftMotor2);
  MotorGroup2 =  new MotorControllerGroup(RightMotor3,RightMotor4);
  DiffDrive = new DifferentialDrive(MotorGroup1,MotorGroup2);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Drive(double Drive,double Turn){
   DiffDrive.arcadeDrive(Drive, Turn);
 }
}
