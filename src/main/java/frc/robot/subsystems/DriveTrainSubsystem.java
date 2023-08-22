// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    public static CANSparkMax leftLead, rightLead, leftFollower, rightFollower;
    private static RelativeEncoder leftLeadEncoder, rightLeadEncoder;
    private static DifferentialDrive diffDrive;


 /**Creates a new driveSubsystem. */
 public DriveTrainSubsystem(){
   leftLead = new CANSparkMax(DriveTrainConstants.leftLeadID , MotorType.kBrushless);
   rightLead = new CANSparkMax(DriveTrainConstants.rightLeadID , MotorType.kBrushless);
   leftFollower = new CANSparkMax(DriveTrainConstants.leftFollowerID , MotorType.kBrushless);
   rightFollower = new CANSparkMax(DriveTrainConstants.rightFollowerID , MotorType.kBrushless);
   leftLead.setInverted(DriveTrainConstants.leftLeadinverted);
   rightLead.setInverted(DriveTrainConstants.rightLeadinverted);
   leftFollower.follow(leftLead);
   rightFollower.follow(rightLead);
    diffDrive = new DifferentialDrive(leftLead, rightLead);
 }
 

 public double ReturnsLeftDistanceValue () {
    return leftLeadEncoder.getPosition();
 }

 public double ReturnsRightDistanceValue () {
    return rightLeadEncoder.getPosition();
 }

 public void ResetDistance () {
    leftLeadEncoder.setPosition(0);
    rightLeadEncoder.setPosition (0);
 }

 public double AverageDistance () {
    return (ReturnsLeftDistanceValue() + ReturnsRightDistanceValue())/2;
 }


 @Override 
 public void periodic() {
    
 }
public void arcadedrive(double leftjoystick, double rightjoystick) {
   diffDrive.arcadeDrive (leftjoystick, rightjoystick);

}
}


  

  


  