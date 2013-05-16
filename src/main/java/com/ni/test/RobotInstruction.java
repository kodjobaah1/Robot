package com.ni.test;

import com.ni.test.vo.Location;
import com.ni.test.vo.Position;

public class RobotInstruction {

	private Location upperRight;
	private Position position;
	private String movements;

	public RobotInstruction(Location upperRightLocation,
			Position positionLocation, String movements) {
		
			this.upperRight = upperRightLocation;
			this.position = positionLocation;
			this.movements = movements;
	}

	public Location getUpperRight() {
		return upperRight;
	}

	public Position getPosition() {
		return position;
	}

	public String getMovements() {
		return movements;
	}

}
