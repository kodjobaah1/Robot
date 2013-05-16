package com.ni.test;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

public class DirectionLookupTest {

	
    @Test
    public void testInvalidDirection() {
		Direction invalid = DirectionLookup.getDirection("Q");
		
		assertThat(invalid,nullValue());	
    }
	@Test
	public void testGetNorth() {
		
		Direction north = DirectionLookup.getDirection("N");
		
		assertThat(north,equalTo(Direction.NORTH));
		
	}
	
	@Test
	public void testGetSouth() {
		
		Direction south = DirectionLookup.getDirection("S");
		
		assertThat(south,equalTo(Direction.SOUTH));
		
	}
	
	@Test
	public void testGetWest() {
		
		Direction west = DirectionLookup.getDirection("W");
		
		assertThat(west,equalTo(Direction.WEST));
		
	}
	
	@Test
	public void testGetEast() {
		
		Direction east = DirectionLookup.getDirection("E");
		
		assertThat(east,equalTo(Direction.EAST));
		
	}
	
	@Test
	public void testGetSouthString() {
		
		String south = DirectionLookup.getDirectionType(Direction.SOUTH);
		
		assertThat(south,equalTo("S"));
	}
	
	@Test
	public void testGetNorthString() {
		
		String north = DirectionLookup.getDirectionType(Direction.NORTH);
		
		assertThat(north,equalTo("N"));
	}
	
	@Test
	public void testGetWestString() {
		
		String west = DirectionLookup.getDirectionType(Direction.WEST);
		
		assertThat(west,equalTo("W"));
	}
	
	@Test
	public void testGetEastString() {
		
		String east = DirectionLookup.getDirectionType(Direction.EAST);
		
		assertThat(east,equalTo("E"));
	}
}
