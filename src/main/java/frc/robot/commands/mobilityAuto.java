package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

public class mobilityAuto extends SequentialCommandGroup{


    
    public mobilityAuto(DriveTrain Drivetrain,double rotation, double velocity, double time){
        addCommands(Commands.runOnce(()-> {

            DriveTrain.setRaw(velocity, rotation);
        
        },
        Drivetrain),
        
        new WaitCommand(time),
        
        Commands.runOnce(()-> {
            DriveTrain.setRaw(velocity, rotation);
        },
        
        Drivetrain)); } 
}
