// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private static CANSparkMax leftFront;
  private static CANSparkMax leftBack;
  private static CANSparkMax rightFront;
  private static CANSparkMax rightBack;
  private static RelativeEncoder rightLeadEncoder;
  private static RelativeEncoder leftLeadEncoder; 
  private static DifferentialDrive differentialDrive;
  
  public DriveTrain() {
    leftFront = new CANSparkMax(DriveTrainConstants.frontLeftCANID, MotorType.kBrushless);
    leftBack = new CANSparkMax(DriveTrainConstants.backlLeftCANID, MotorType.kBrushed);
    rightFront = new CANSparkMax(DriveTrainConstants.frontrightCANID, MotorType.kBrushless);
    rightBack = new CANSparkMax(DriveTrainConstants.backRightCANID, MotorType.kBrushless);
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);
    leftLeadEncoder = leftFront.getEncoder();
    rightLeadEncoder = rightFront.getEncoder();
    differentialDrive = new DifferentialDrive(leftFront, rightFront);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double driveStick, double turnStick) {
    differentialDrive.arcadeDrive(driveStick, turnStick);
  }
}
