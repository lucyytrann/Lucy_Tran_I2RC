package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class PIDTurnccw extends Command{
    DriveTrain dt; 
    double setPointAngle;
    PIDController pid = new PIDController(0.7/90, 0, 0);
    Double output;

    public PIDTurnccw(DriveTrain dt, double setPointAngle){
        this.dt = dt;
        this.setPointAngle = setPointAngle;
        addRequirements(dt); //prevent conflict with each other 
        pid.setTolerance(5); 

       
    }

    public void initialize() {
         dt.reset();
        dt.tankDrive(0, 0);
    }
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        output = pid.calculate(dt.getAngle(), setPointAngle);
        dt.tankDrive(-output, output);
        
    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        dt.tankDrive(0, 0); 
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
       return pid.atSetpoint();
    }


}
