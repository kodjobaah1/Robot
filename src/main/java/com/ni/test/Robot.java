package com.ni.test;

import com.ni.test.vo.Location;
import com.ni.test.vo.Position;

public class Robot {
	
	private Location upperRight;
	private Position position;
	
	public Robot(Location upperRight, Position position) {
		
		Integer locationX = position.getLocation().getX();
		Integer locationY = position.getLocation().getY();
		
		if ((locationY > upperRight.getY()) ||
		   (locationX > upperRight.getX())) {
			  throw new RuntimeException("Can not position robot outside of plateau");
		}
		
		this.position = position;
		this.upperRight = upperRight;
	}
	
	public void move() throws WallException {
		
		switch(position.getDirection()) {
		
		case NORTH:
				moveUp();
			break;
		case SOUTH:
				moveDown();
			break;	
		case EAST:
				moveRight();
			break;		
		case WEST:
			
				moveLeft();
			break;
		
		}
		
	}

	public void moveUp() throws WallException {
		
		Integer upperRightPos = upperRight.getY();
		
		Integer currentLoc = position.getLocation().getY();
		Integer newLoc = currentLoc + 1;
		
		if (newLoc > upperRightPos) {
			throw new WallException("I can not go up anymore");
		}
		
		position.getLocation().setY(newLoc);
	}
	
	public void moveDown() throws WallException {
		
		Integer currentLoc = position.getLocation().getY();
		Integer newLoc = currentLoc - 1;
		
		if (newLoc < 0)
			throw new WallException("I can not go down anymore");
		
		position.getLocation().setY(newLoc);
	}
	
	public void moveRight() throws WallException {
		
		Integer upperRightPos = upperRight.getX();
		
		Integer currentLoc = position.getLocation().getX();
		Integer newLoc = currentLoc + 1;
		
		if  (newLoc > upperRightPos) {
			throw new WallException("I can not go right anymore");
		}
		
		position.getLocation().setX(newLoc);
		
	}
	
	public void moveLeft() throws WallException {
		
		Integer currentLoc = position.getLocation().getX();
		Integer newLoc = currentLoc  - 1;
		
		if (newLoc < 0)  {
			throw new WallException("I can not go left anymore");
		}
		
		position.getLocation().setX(newLoc);
	}
	
	public void spinRight() {
		
		Direction currentDirection = position.getDirection();
		
		Direction newDirection = null;
		if (currentDirection == Direction.NORTH) {
			newDirection = Direction.EAST;
			
		} else if (currentDirection == Direction.WEST ) {
			newDirection = Direction.NORTH;
		} else {
			Integer curDirectionValue = currentDirection.getValue();
			curDirectionValue = curDirectionValue + 90;
			newDirection = Direction.getDirection(curDirectionValue);
		}
		
		position.setDirection(newDirection);

	}
	
	public void spinLeft() {
		
		Direction currentDirection = position.getDirection();
		
		Direction newDirection = null;
		if (currentDirection == Direction.NORTH) {
			newDirection = Direction.WEST;
			
		} else if (currentDirection == Direction.EAST ) {
			newDirection = Direction.NORTH;
		} else {
			Integer curDirectionValue = currentDirection.getValue();
			curDirectionValue = curDirectionValue - 90;
			newDirection = Direction.getDirection(curDirectionValue);
		}
		
		position.setDirection(newDirection);

	}
	
	
	
	public String displayPosition() {
		String pos = 
				position.getLocation().getX()+" "+
				position.getLocation().getY()+" "+
				DirectionLookup.getDirectionType(position.getDirection());
		
		return pos;
	}
	public Position getPosition() {
		return position;
	}


	
	

}
