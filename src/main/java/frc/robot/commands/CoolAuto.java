// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveTrain;
import frc.robot.subsystems.ILoveDriveTrain;

public class CoolAuto extends CommandBase {
  /** Creates a new CoolAuto. */
  private final ILoveDriveTrain driveTrain;
  private final double distance;
  private final double speed;
  public CoolAuto(double distance, double speed, ILoveDriveTrain ILoveDriveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = ILoveDriveTrain;
    this.distance = distance;
    this.speed = speed;
    addRequirements(ILoveDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetPosition(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.DiffDrive(speed, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.DiffDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return driveTrain.avgPos() >= Math.abs(distance);
  }
}
