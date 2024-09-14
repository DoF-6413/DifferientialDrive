package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain.drive;

public class MobilityAuto extends SequentialCommandGroup{



    public MobilityAuto (double velocity,double rotation, double time, drive Drivetrain){

        addCommands(Commands.runOnce(()-> {

            drive.setRaw(velocity, rotation );
        }, 
        Drivetrain),
        
        new WaitCommand(time),

        Commands.runOnce(()-> {

            drive.setRaw(0,0);

        },
        
        Drivetrain));
    }   
}
