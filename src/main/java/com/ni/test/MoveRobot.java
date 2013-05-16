package com.ni.test;

public class MoveRobot {
	
	private ProcessInput processInput;
	private Robot robot;
	
	public MoveRobot() {
		processInput  = new ProcessInput();
	}
	
	public void moveRobot() {
		
		
		RobotInstruction robotInstruction = processInput.processInput();
		
		if (robotInstruction != null) {
			robot = new Robot(robotInstruction.getUpperRight(),robotInstruction.getPosition());
	
			String movements = robotInstruction.getMovements();
			
			for(Character move: movements.toCharArray()) {
				
				switch(Character.toUpperCase(move)) {
				
				case 'L':
						robot.spinLeft();
					break;
				case 'R':
						robot.spinRight();
					break;
				case 'M':
					
					try {
						robot.move();
					} catch (WallException e) {
						throw new RuntimeException(e.getMessage());
					}
					break;
				}
		
			}
			
		 System.out.println(robot.displayPosition());
		} else {
			throw new RuntimeException("Invalid Robot Instructions");
		}
	}

}
