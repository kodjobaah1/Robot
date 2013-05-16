package com.ni.test.validator;

public class ValidateLocation {

	public boolean validateLocation(String val) {

		String [] positions = val.trim().split(" ");

		if (positions.length != 2) {
			return false;
		}

		try {
			Integer x =  Integer.parseInt(positions[0]);
			Integer y =  Integer.parseInt(positions[1]);

			//checking to see if the values fit with our cordinate systen
			if ((x < 0) || (y < 0)) {
				return false;
			}

		} catch(NumberFormatException nfe) {
			return false;
		}

		return true;
	}

}
