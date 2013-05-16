package com.ni.test.vo;

import com.ni.test.Direction;

public class Position {
	
	private Location location;
	
	private Direction direction;
	
	public Position(Location location, Direction direction) {
		this.location = location;
		this.direction = direction;
	}

	public Location getLocation() {
		return location;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	

}
