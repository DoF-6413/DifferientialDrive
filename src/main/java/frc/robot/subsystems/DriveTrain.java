package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
    private final CANSparkMax leftMotorBack, leftMotorFront, rightMotorBack, rightMotorFront;
    private final MotorControllerGroup leftMotors, rightMotors;
    private final RelativeEncoder leftEncoder, rightEncoder;
    private static DifferentialDrive DriveTrain;


public DriveTrain() {
    leftMotorBack = new CANSparkMax(DriveTrainConstants.LEFT_BACK_MOTOR_CAN_ID, MotorType.kBrushless);
    leftMotorFront = new CANSparkMax(DriveTrainConstants.LEFT_FRONT_MOTOR_CAN_ID,MotorType.kBrushless);
    rightMotorBack = new CANSparkMax(DriveTrainConstants.RIGHT_BACK_MOTOR_CAN_ID,MotorType.kBrushless);
    rightMotorFront = new CANSparkMax(DriveTrainConstants.RIGHT_FRONT_MOTOR_CAN_ID,MotorType.kBrushless);
    leftMotorBack.setIdleMode(IdleMode.kBrake);
    leftMotorFront.setIdleMode(IdleMode.kBrake);
    rightMotorBack.setIdleMode(IdleMode.kBrake);
    rightMotorFront.setIdleMode(IdleMode.kBrake);
    leftMotorBack.setInverted(DriveTrainConstants.LEFT_MOTORS_INVERTED);
    leftMotorFront.setInverted(DriveTrainConstants.LEFT_MOTORS_INVERTED);
    rightMotorBack.setInverted(DriveTrainConstants.RIGHT_MOTORS_INVERTED);
    rightMotorFront.setInverted(DriveTrainConstants.RIGHT_MOTORS_INVERTED);
    leftMotors = new MotorControllerGroup(leftMotorBack, leftMotorFront);
    rightMotors = new MotorControllerGroup(rightMotorBack, rightMotorFront);
    leftEncoder = leftMotorFront.getEncoder();
    rightEncoder = rightMotorBack.getEncoder();
    DriveTrain = new DifferentialDrive(leftMotors, rightMotors);
}

@Override
public void periodic() {
}

public void DiffDrive(double leftMotorValue, double rightMotorValue) {
    DriveTrain.arcadeDrive(leftMotorValue, rightMotorValue);
}

public void resetPosition(double resetPosition) {
    leftEncoder.setPosition(resetPosition);
    rightEncoder.setPosition(resetPosition);
}

public double leftPos() {
    return leftEncoder.getPosition();
}

public double rightPos() {
    return rightEncoder.getPosition();
}

public double avgPos() {
    return (leftPos() + rightPos()) / 2;
}

public static void setRaw(double velocity, double rotation) {
    DriveTrain.arcadeDrive(velocity, rotation);
}
}