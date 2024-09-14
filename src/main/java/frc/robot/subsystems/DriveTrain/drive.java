package frc.robot.subsystems.DriveTrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.drivetrain;


public class drive extends SubsystemBase {
 //creating a new drive train
  private final CANSparkMax LeftFrontMotor, LeftBackMotor, RightFrontMotor, RightBackMotor;
  private final MotorControllerGroup LeftMotors, RightMotors;
  private final RelativeEncoder LeftEncoder, RightEncoder;
  private static  DifferentialDrive diffdrive;

  public drive(){
    //initialise the motors
    LeftFrontMotor = new CANSparkMax(drivetrain.LEFT_FRONT_MOTOR_ID, MotorType.kBrushless);
    LeftBackMotor = new CANSparkMax(drivetrain.LEFT_BACK_MOTOR_ID,MotorType.kBrushless);
    RightFrontMotor = new CANSparkMax(drivetrain.RIGHT_FRONT_MOTOR_ID,MotorType.kBrushless);
    RightBackMotor = new CANSparkMax(drivetrain.RIGHT_BACK_MOTOR_ID,MotorType.kBrushless);
    //setting motors to break mode
    LeftFrontMotor.setIdleMode(IdleMode.kBrake);
    LeftBackMotor.setIdleMode(IdleMode.kBrake);
    RightFrontMotor.setIdleMode(IdleMode.kBrake);
    RightBackMotor.setIdleMode(IdleMode.kBrake);
    //setting inverted motors
    LeftFrontMotor.setInverted(drivetrain.LEFT_MOTORS_INVERTED);
    LeftBackMotor.setInverted(drivetrain.LEFT_MOTORS_INVERTED);
    RightFrontMotor.setInverted(drivetrain.RIGHT_MOTORS_INVERTED);
    RightBackMotor.setInverted(drivetrain.RIGHT_MOTORS_INVERTED);
    //creating motor control group
    LeftMotors = new MotorControllerGroup(LeftFrontMotor, LeftBackMotor);
    RightMotors = new MotorControllerGroup(RightFrontMotor, RightBackMotor);
    //creating encoders
    LeftEncoder = LeftFrontMotor.getEncoder();
    RightEncoder = RightFrontMotor.getEncoder();
    diffdrive = new DifferentialDrive(LeftFrontMotor, RightFrontMotor);
  }

  @Override
  public void periodic (){
  }
  public void diffdrive (double Velocity, double Rotation){
    diffdrive.arcadeDrive(Velocity, Rotation);
  }
  public void ResetPosition(double ResetPosition){
    LeftEncoder.setPosition(ResetPosition);
    RightEncoder.setPosition(ResetPosition);
  }
  public double LeftPosition(){
    return LeftEncoder.getPosition();
  }
  public double RightPosition(){
    return RightEncoder.getPosition();
  }
  public double AveragePosition(){
    return (LeftPosition() + RightPosition())/2;
  }

  public static void setRaw (double velocity, double rotation) {
    diffdrive.arcadeDrive(velocity, rotation);
  }
}
