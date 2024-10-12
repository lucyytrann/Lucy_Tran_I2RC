// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  private final WPI_TalonSRX leftDriveTalon; 
  private final WPI_TalonSRX rightDriveTalon;
  private AHRS NavX = new AHRS(SPI.Port.kMXP);
  /** Creates a new ExampleSubsystem. */
  
  public DriveTrain(){
    leftDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPort.leftDriveTalon);
    rightDriveTalon = new WPI_TalonSRX(Constants.DriveTrainPort.rightDriveTalon);
    leftDriveTalon.setNeutralMode(NeutralMode.Coast);
    rightDriveTalon.setNeutralMode(NeutralMode.Coast);

    leftDriveTalon.setSensorPhase(true);
    rightDriveTalon.setSensorPhase(true);
    leftDriveTalon.configFactoryDefault();
    leftDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    rightDriveTalon.configFactoryDefault();
    rightDriveTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    leftDriveTalon.set(leftSpeed);
    rightDriveTalon.set(rightSpeed); 
  }

  public void reset(){
    NavX.reset();
  }

  public double getAngle(){
    return NavX.getAngle();
  }

  public double getTicks(){
    return (leftDriveTalon.getSelectedSensorPosition(0) + rightDriveTalon.getSelectedSensorPosition(0))/2;
  }

  public double getMeters(){
    return Units.inchesToMeters(6) * Math.PI / 4096 * getTicks();
  }

  public void resetEncoders(){
    leftDriveTalon.setSelectedSensorPosition(0,0,10);
    rightDriveTalon.setSelectedSensorPosition(0,0,10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Voltage", leftDriveTalon.getMotorOutputPercent());
    SmartDashboard.putNumber("Right Voltage", rightDriveTalon.getMotorOutputPercent());
    SmartDashboard.putNumber("Meters", getMeters());
    SmartDashboard.putNumber("Angle", getAngle());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
