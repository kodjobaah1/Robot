package com.ni.test.validator;



/**
 * 
 * @author kodjobaah
 *
 * Note: Because of way this class is designed to be used..
 * we do not check for index of bound exceptions.
 * 
 */
public class ValidatePosition {
	
	
	private ValidateLocation validateLocation;
	
	public ValidatePosition() {
		validateLocation = new ValidateLocation();
	}
	public boolean validatePosition(String val) {
		
		String[] positions = val.trim().split(" ");
		
		if (positions.length != 3) {
			return false;
		}
			
		if (!validateLocation.validateLocation(getLocation(val))) {
			return false;
		}
		
		return true;
	}
	
	public String getLocation(String val) {
		return val.substring(0,3).trim();
	}
	
	public String getDirection(String val) {
		return val.substring(3).trim();
	}

}
