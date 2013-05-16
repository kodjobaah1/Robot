package com.ni.test;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ni.test.vo.Location;
import com.ni.test.vo.Position;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RobotTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testForWhenTryingToPlaceRobotOutSideOfPlateua() {

			thrown.expect(RuntimeException.class);
			thrown.expectMessage("Can not position robot outside of plateau");
			Location upperRight = new Location(5,5);
			
			Location curLocation = new Location(6,6);
			Direction direction = Direction.NORTH;
			Position position = new Position(curLocation,direction);
			
			Robot robot = new Robot(upperRight,position);

	}
	@Test
	public void testSpinLeftWhenFacingNorth() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.NORTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinLeft();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.WEST));
		
	}
	
	@Test
	public void testSpinRightWhenFacingNorth() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.NORTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinRight();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.EAST));
		
	}
	
	@Test
	public void testSpinRightWhenFacingEast() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.EAST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinRight();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.SOUTH));
		
	}
	
	@Test
	public void testSpinLeftWhenFacingEast() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.EAST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinLeft();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.NORTH));
		
	}
	
	
	@Test
	public void testSpinRightWhenFacingWest() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.WEST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinRight();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.NORTH));
		
	}
	
	@Test
	public void testSpinLeftWhenFacingWest() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.WEST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinLeft();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.SOUTH));
		
	}
	
	@Test
	public void testSpinRightWhenFacingSouth() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.SOUTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinRight();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.WEST));
		
	}
	
	@Test
	public void testSpinLeftWhenFacingSouth() {
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.SOUTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.spinLeft();
		
		assertThat(robot.getPosition().getDirection(),equalTo(Direction.EAST));
		
	}
	
	
	@Test
	public void testMoveRightOnce() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.EAST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getX();
		
		assertThat(loc,equalTo(3));
		
	}
	
	@Test
	public void testMoveRightTwice() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.EAST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getX();
		
		assertThat(loc,equalTo(4));
		
	}

	
	@Test
	public void testMovingRightBeyondWall() throws WallException {
			
			thrown.expect(WallException.class);
			thrown.expectMessage("I can not go right anymore");
			Location upperRight = new Location(5,5);
			Location curLocation = new Location(2,2);
			Direction direction = Direction.EAST;
			Position position = new Position(curLocation,direction);
			Robot robot = new Robot(upperRight,position);
			
			robot.move();
			robot.move();
			robot.move();
			robot.move();

	}
	
	
	@Test
	public void testMoveLeftOnce() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.WEST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getX();
		
		assertThat(loc,equalTo(1));
		
	}
	
	@Test
	public void testMoveLeftTwice() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,2);
		Direction direction = Direction.WEST;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getX();
		
		assertThat(loc,equalTo(0));
		
	}

	
	@Test
	public void testMovingLeftBeyondWall() throws WallException {
			
			thrown.expect(WallException.class);
			thrown.expectMessage("I can not go left anymore");
			Location upperRight = new Location(5,5);
			Location curLocation = new Location(2,2);
			Direction direction = Direction.WEST;
			Position position = new Position(curLocation,direction);
			Robot robot = new Robot(upperRight,position);
			
			robot.move();
			robot.move();
			robot.move();

	}
	
	
	@Test
	public void testMoveUpOnce() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,3);
		Direction direction = Direction.NORTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getY();
		
		assertThat(loc,equalTo(4));
		
	}
	
	@Test
	public void testMoveUpTwice() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,3);
		Direction direction = Direction.NORTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getY();
		
		assertThat(loc,equalTo(5));
		
	}

	
	@Test
	public void testMovingUpBeyondWall() throws WallException {
			
			thrown.expect(WallException.class);
			thrown.expectMessage("I can not go up anymore");
			Location upperRight = new Location(5,5);
			Location curLocation = new Location(2,3);
			Direction direction = Direction.NORTH;
			Position position = new Position(curLocation,direction);
			Robot robot = new Robot(upperRight,position);
			
			robot.move();
			robot.move();
			robot.move();

	}
	
	
	@Test
	public void testMoveDownOnce() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,3);
		Direction direction = Direction.SOUTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getY();
		
		assertThat(loc,equalTo(2));
		
	}
	
	@Test
	public void testMoveDownTwice() throws WallException{
		
		Location upperRight = new Location(5,5);
		
		Location curLocation = new Location(2,3);
		Direction direction = Direction.SOUTH;
		Position position = new Position(curLocation,direction);
		
		Robot robot = new Robot(upperRight,position);
		
		robot.move();
		robot.move();
		
		Integer loc = robot.getPosition().getLocation().getY();
		
		assertThat(loc,equalTo(1));
		
	}

	
	@Test
	public void testMovingDownBeyondWall() throws WallException {
			
			thrown.expect(WallException.class);
			thrown.expectMessage("I can not go down anymore");
			Location upperRight = new Location(5,5);
			Location curLocation = new Location(2,2);
			Direction direction = Direction.SOUTH;
			Position position = new Position(curLocation,direction);
			Robot robot = new Robot(upperRight,position);
			
			robot.move();
			robot.move();
			robot.move();

	}

}
