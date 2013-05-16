package com.ni.test;

import java.util.Scanner;

import com.ni.test.validator.ValidateLocation;
import com.ni.test.validator.ValidateMovement;
import com.ni.test.validator.ValidatePosition;
import com.ni.test.vo.Location;
import com.ni.test.vo.Position;

public class ProcessInput {


	ValidateLocation validateLocation;
	ValidatePosition validatePosition;
	ValidateMovement validateMovement;
	
	public ProcessInput() {
	
		validateLocation = new ValidateLocation();
		validatePosition = new ValidatePosition();
		validateMovement = new ValidateMovement();
	}
	
	public RobotInstruction processInput() {

		Scanner scanner = new Scanner(System.in);

		String upperRight = scanner.nextLine();
		if (upperRight == null) {
			return null;
		}

		
		if (!validateLocation.validateLocation(upperRight)) {
			return null;
		}

		String position = scanner.nextLine();
		if (position == null) {
			return null;
		}

		
		if (!validatePosition.validatePosition(position)) {
			return null;
		}

		String movements = scanner.nextLine();
		if (movements == null) {
			return null;
		}

		
		if (!validateMovement.validateMovement(movements)) {
			return null;
		}



		Location upperRightLocation = createLocation(upperRight);

		Location posLocation = createLocation(validatePosition.getLocation(position));
		Direction direction = DirectionLookup.getDirection(validatePosition.getDirection(position));
		Position positionLocation = new Position(posLocation,direction); 

		RobotInstruction robotInstruction = 
				new RobotInstruction(upperRightLocation,positionLocation,movements);

		return robotInstruction;

	}

	private Location createLocation(String loc) {
		String[] locs = loc.split(" ");
		Location location = new Location(Integer.parseInt(locs[0]),
				Integer.parseInt(locs[1]));

		return location;

	}

}
