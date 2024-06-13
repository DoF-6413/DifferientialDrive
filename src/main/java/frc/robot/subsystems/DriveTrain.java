// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

/** Creates a new DriveTrain. */
public class DriveTrain extends SubsystemBase {
  // Create the CANSparkMax objects for all 4 motors
  private static CANSparkMax sparkMax;
  /* Motor 2 */
  /* Motor 3 */
  /* Motor 4 */

  // Create the RelativeEncoder objects for both sides of the drivetrain
  private static RelativeEncoder encoder;
  /* Encoder 2 */

  
  // Create a DifferentialDrive object
  /* DiffDrive object */

  public DriveTrain() {
    // Initialize all 4 CANSparkMax objects
    sparkMax = new CANSparkMax(0, MotorType.kBrushless);
    /* Motor 2 */
    /* Motor 3 */
    /* Motor 4 */

    // Set the default mode for each SparkMax
    sparkMax.setIdleMode(IdleMode.kBrake);
    /* Motor 2 */
    /* Motor 3 */
    /* Motor 4 */

    // Set the inversion status of each motor
    sparkMax.setInverted(true);

    encoder = sparkMax.getEncoder();
    encoder.setPositionConversionFactor(DriveTrainConstants.TICKS_TO_INCHES);
    /* Encoder 2 */
    /* Encoder 2 Conversion Factor */

    /* Diffdrive */
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /* What parameters are needed? */
  public void arcadeDrive() {
    /* Use the .arcadeDrive method from your diffdrive object */
    
  }

  public void resetPos() {
    encoder.setPosition(0);
    /* Encoder 2 */
  }

  public double getLeftPos() {
    return encoder.getPosition();
  }

  public double getRightPos() {
    /* Return the position for the second encoder */
    return 0.0;
  }

  public double getAvgPos() {
    /* Return the average of the two poses */
    return 0.0;
  }
} 
