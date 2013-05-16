package com.ni.test;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DirectionTest {
	
	@Test
	public void testForNorth() {
		
		Direction direction = Direction.getDirection(0);
		
		assertThat(direction,equalTo(Direction.NORTH));
		
	}
	
	@Test
	public void testForSouth() {
		
		Direction direction = Direction.getDirection(180);
		
		assertThat(direction,equalTo(Direction.SOUTH));
	}
	
	@Test
	public void testForEast() {
		Direction direction = Direction.getDirection(90);
		
		assertThat(direction,equalTo(Direction.EAST));
	}
	
	@Test
	public void testForWest() {
		Direction direction = Direction.getDirection(270);
		
		assertThat(direction,equalTo(Direction.WEST));
	}
	
	

}
