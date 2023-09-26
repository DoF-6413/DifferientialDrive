// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
 

public class ILoveDriveTrain extends SubsystemBase {
  /** Creates a new stinkydrivetrain. */
  private final CANSparkMax LeftMotor, LeftMotor2, RightMotor, RightMotor2;
  private final RelativeEncoder LeftEncoder, RightEncoder;
  private final DifferentialDrive ILoveDiffDrive;
  public ILoveDriveTrain() {

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
