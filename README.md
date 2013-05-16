Robot
=====

Robot
The main entry to the application is the class MoveRobot which reads one set of instructions and processes them.

If any of the instructions are invalid it just throws a runtime exception. Sometimes it does not give clear enough
information about why the exception occured.
 
Note: No validation is being done on the initial position instruction. Instead of entering (1 2 N) and a user
enters (1 2 X) then the application blows up.

MoveRobot -- Main class
Direction -- Enum used to hold the direction 
DirectionLookup -- Utility class used to convert directions to string and vise versa. 
ProcessInput -- Used to process the users input
Robot -- The robot that is being moved 
RobotInstruction -- The instruction acquired from processing the users input
WallException -- Thrown when a robot hits a wall

com.ni.test.validator
ValidateLocation  -- Used to validate the location
ValidateMovement  -- Used to validate the movement
ValidatePosition -- Used to validate the starting position

com.ni.test.vo
Location -- The location
Position.java -- The poistion wich inlcudes location and direction



