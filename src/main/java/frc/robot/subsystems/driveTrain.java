// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveTrainConstants;

public class driveTrain extends SubsystemBase {
  /** Creates a new driveTrain. */
  private final CANSparkMax Spooky;
  private final CANSparkMax Candy;
  private final CANSparkMax Ghost;
  private final CANSparkMax BOO;
  private final DifferentialDrive Twigs; 
  public driveTrain() {
    Spooky = new  CANSparkMax(driveTrainConstants.SpookyID, MotorType.kBrushless);
    Candy = new  CANSparkMax(driveTrainConstants.CandyID, MotorType.kBrushless);
    Ghost = new  CANSparkMax(driveTrainConstants.GhostID, MotorType.kBrushless);
    BOO = new  CANSparkMax(driveTrainConstants.BOOID, MotorType.kBrushless);

    Spooky.setInverted(driveTrainConstants.SpookyInverted);
    Candy.setInverted(driveTrainConstants.CandyInverted);
    Ghost.setInverted(driveTrainConstants.GhostInverted);
    BOO.setInverted(driveTrainConstants.BOOInverted);




    Spooky.follow(BOO);
    Candy.follow(Ghost);

    Twigs = new DifferentialDrive(Ghost, BOO);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void drive(double drive , double turn) {

    Twigs.arcadeDrive(drive, turn);
  }

  
}
