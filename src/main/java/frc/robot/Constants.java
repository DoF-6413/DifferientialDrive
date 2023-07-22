// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class DriveTrainConstants {
    public static final double WheelRadius = 3/12;
    public static final double GearRatio = 8.68;
    public static final double TicksToFeet = (WheelRadius * 2 * Math.PI)/GearRatio;
    public static final int RightMotor1CANID = 4;
    public static final int RightMotor2CANID = 5;
    public static final int LeftMotor1CANID = 2;
    public static final int LeftMotor2CANID = 3;
    public static final boolean RightMotor1Inverted = true;
    public static final boolean RightMotor2Inverted = true;
    public static final boolean LeftMotor1Inverted = false;
    public static final boolean LeftMotor2Inverted = false;
    
  }
}
