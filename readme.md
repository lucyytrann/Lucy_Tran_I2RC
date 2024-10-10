# Preseason Digital Notebook Example
Name: Lucy

Section: I2RC/ARC

Week: 2

## Code

The main topic this week was: EncoderDrive

Commands: EncoderDrive

Subsystems: DriveTrain

### How does the code work?
Write about how it works here
Subsystems - DriveTrain: 
The getTicks() method worked by get the position of the leftDriveTalon and rightDriveTalon and add them up and divided by 2 in order to get the average. 
The getMeters() method worked by convert ticks into meter by get the current tick then multiply it by pi and divided by 4096. 
The resetEncoders() worked by get the position of both of the leftDriveTalon and rightDriveTalon and set them to 0 because robots lways need to restart its position at 0. 

Commands - EncoderDrive: 
The initialize() method worked by reset the encoder and tank drive of DriveTrain to 0, in order to make the beginning speed of robot at 0. 
The execute() method will make the robot runs constantly by set the speed of leftDriveTalon and rightDriveTalon of DriveTrain into the constant number
The end() method is set the speed of the robots to 0 by set the speed of leftDriveTalon and rightDriveTalon of DriveTrain into 0. 
The isFinished() worked by return true when the robot has reached its setPoint, otherwise, it will return falses. 

### Important notes for future reference
Notes about git, and helpful resources, etc. 
N/A

Please put them here, they will really help you in the future 