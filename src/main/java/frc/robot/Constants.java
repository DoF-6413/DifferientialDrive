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
    public static final int DRIVE_CONTROLLER_PORT = 0;
  }
  public static final class DriveTrainConstants  {
    public static final int WHEEL_RAD = 2;  // 2 inches
    public static final double WHEEL_DIAMETER = 4;  // 4 inches
    public static final int MAX_LINEAR_VELOCITY = 6; // 6km/hr
    public static final int LEFT_BACK_MOTOR_CAN_ID = 3;
    public static final int LEFT_FRONT_MOTOR_CAN_ID = 2;
    public static final int RIGHT_BACK_MOTOR_CAN_ID = 5;
    public static final int RIGHT_FRONT_MOTOR_CAN_ID = 4;
    public static final boolean LEFT_MOTORS_INVERTED = false;
    public static final boolean RIGHT_MOTORS_INVERTED = true;
  }
}
