# Preseason Digital Notebook Example
Name: Lucy Tran

Section: I2RC

Week: 2


## Code

The main topic this week was: PID

Commands: PIDTurnccw

Subsystems: DriveTrain

### How does the code work?
The PIDTurnccw constructor work by assign the parameter dt, and setpointAngle to the instance variable. The addRequirements(dt) is to prevent the conflict with each other. After that there are some line of code help to store the error by using pid.setTolerance() (however, I don't really know how to code this). The initialize() method worked by reset the tank drive of DriveTrain to 0, in order to make the beginning speed of robot at 0. The execute() method will calculates output in order to help the robot to turn counterclockwise if a positive angle is inputted, and clockwise if a negative angle is inputted (again, I also don't really know how to code ths). The end() method is set the speed of the robots to 0 by set the speed of leftDriveTalon and rightDriveTalon of DriveTrain into 0. The isFinished() worked by return true when atSetpoint() method also return true, in other word, the robot will stop when it has reached the setpoint. 


### Important notes for future reference
Notes about git, and helpful resources, etc. N/A

Please put them here, they will really help you in the future 