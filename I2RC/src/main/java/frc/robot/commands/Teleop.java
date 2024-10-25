package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.Joystick;

public class Teleop extends Command{
    DriveTrain dt; 
    Joystick joystick; 
    double leftPower;
    double rightPower;

    public Teleop(Joystick joystick){
        this.joystick = joystick;
        leftPower = joystick.getRawAxis(1);
        leftPower = joystick.getRawAxis(5);
    }


    public void initialize() {
        dt.tankDrive(0, 0);
    }
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        dt.tankDrive(leftPower, rightPower);
        
    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        dt.tankDrive(0, 0); 
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
       return true;
    }


}
