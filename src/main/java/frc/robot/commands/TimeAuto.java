// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** Creates a new DistanceAuto. */
public class TimeAuto extends CommandBase {
  /* Define your Drivetrain and other variables */



  /* Add the perameters required for this auto */
  public TimeAuto() {
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /* Reset the position of the drivetrain */

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /* Run the drivetrain */

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    /* Stop the drivetrain */

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*
     *  Create a condition to that indicates the end of the auto.
     *  E.g. after __ time 
     */
    return false;
  }
}
