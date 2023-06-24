// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  public static CANSparkMax m_leftLead, m_rightLead, m_leftFollower, m_rightFollower;
  private static RelativeEncoder m_leftLeadEncoder, m_rightLeadEncoder;
  private static DifferentialDrive m_diffDrive;

  public DrivetrainSubsystem() {
      m_leftLead = new CANSparkMax(DrivetrainConstants.kLeftLeadID, MotorType.kBrushless);
      m_rightLead = new CANSparkMax(DrivetrainConstants.kRightLeadID, MotorType.kBrushless);
      m_leftFollower = new CANSparkMax(DrivetrainConstants.kLeftFollowerID, MotorType.kBrushless);
      m_rightFollower = new CANSparkMax(DrivetrainConstants.kRightFollowerID, MotorType.kBrushless);

      m_leftFollower.follow(m_leftLead);
      m_rightFollower.follow(m_rightLead);

      m_leftLeadEncoder = m_leftLead.getEncoder();
      m_rightLeadEncoder = m_rightLead.getEncoder();

      m_leftLeadEncoder.setPositionConversionFactor(DrivetrainConstants.kTicksToMeters);
      m_rightLeadEncoder.setPositionConversionFactor(DrivetrainConstants.kTicksToMeters);

      m_diffDrive = new DifferentialDrive(m_leftLead, m_rightLead);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drivetrain Position Meters", getAveragePositionMeters());
  }

  public void tankDrive(double leftPercent, double rightPercent){
    m_diffDrive.tankDrive(leftPercent, rightPercent);
  }

  public void arcadeDrive(double drivePercent, double turnPercent){
    m_diffDrive.arcadeDrive(drivePercent, turnPercent);
  }

  public double getPositionMetersLeft(){
    return m_leftLeadEncoder.getPosition();
  }

  public double getPositionMetersRight(){
    return m_rightLeadEncoder.getPosition();
  }

  public double getAveragePositionMeters(){
    return (getPositionMetersLeft() + getPositionMetersRight()) /2;
  }

  public void resetPosition(){
   m_leftLeadEncoder.setPosition(0);
   m_rightLeadEncoder.setPosition(0); 
  }
}
