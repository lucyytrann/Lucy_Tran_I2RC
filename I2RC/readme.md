# Preseason Digital Notebook Example
Name: Lucy Tran

Section: I2RC

Week: 7


## Code

The main topic this week was: TeleOp

Commands: Sequential Commands

Subsystems: **[SUBSYSTEMS]**

### How does the code work?
First I initialize a joystick object, dt object and create variable name leftPower and rightPower. In the Teleop constructor. 
I set the joysticks’ axes to the leftPower by 1 axis and set the joysticks’ axes to the rightPower by 5 axis. The initialize() method worked by reset the tank drive of DriveTrain to 0, in order to make the beginning speed of robot at 0. The execute() method worked by set the leftDriveTalon of the DriveTrain to the leftPower and set the rightDriveTalon of the DriveTrain to the rightPower. The end() method is set the speed of the robots to 0 by set the speed of leftDriveTalon and rightDriveTalon of DriveTrain into 0. The isFinished() worked by return true. 


### Important notes for future reference
Notes about git, and helpful resources, etc. N/A

Please put them here, they will really help you in the future 