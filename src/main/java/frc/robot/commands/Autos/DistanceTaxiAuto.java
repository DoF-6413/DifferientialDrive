// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DistanceTaxiAuto extends CommandBase {
  /** Creates a new DistanceTaxiAuto. */
  private final DrivetrainSubsystem m_drivetrainSubsystem;
  private final double m_distance;
  public DistanceTaxiAuto(DrivetrainSubsystem drive, double distanceMeters) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrainSubsystem = drive;
    m_distance = distanceMeters;
    addRequirements(m_drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrainSubsystem.resetPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_distance > m_drivetrainSubsystem.getAveragePositionMeters()){
      m_drivetrainSubsystem.arcadeDrive(0.5, 0);
    }else if(m_distance < m_drivetrainSubsystem.getAveragePositionMeters()){
      m_drivetrainSubsystem.arcadeDrive(-0.5, 0);
    } else{
      m_drivetrainSubsystem.arcadeDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrainSubsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_distance > 0 ? m_drivetrainSubsystem.getAveragePositionMeters() >= m_distance : m_drivetrainSubsystem.getAveragePositionMeters() <= m_distance;
  }
}
