// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class distanceauto extends CommandBase {
  /** Creates a new distanceauto. */
  public final Drive m_driveySubSystem;
  public final double distance;
  public final double speed;
  public distanceauto(Drive m_driveySubSystem, double distance, double speed) {
    this.m_driveySubSystem = m_driveySubSystem;
    this.distance = distance;
    this.speed = speed;
    addRequirements(m_driveySubSystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveySubSystem.resetpose();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveySubSystem.drive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveySubSystem.drive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_driveySubSystem.getaveragepose() >= distance;
  }
}
