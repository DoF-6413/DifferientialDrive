// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class DistanceAuto extends CommandBase {
  driveTrain driveTrain;
  double distance;
  double speed;
  /** Creates a new DistanceAuto. */
  public DistanceAuto(driveTrain driveTrain, double distance, double speed) {
    this.driveTrain = driveTrain;
    this.distance = distance;
    this.speed = speed;
    addRequirements(driveTrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetEncoderPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.drive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (distance <= driveTrain.getEncoderDistance());
  }
}
