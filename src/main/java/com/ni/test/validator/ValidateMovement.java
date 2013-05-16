package com.ni.test.validator;

public class ValidateMovement {
	
	public boolean validateMovement(String value) {
		
		
		String newValue = value.trim().toUpperCase().replace("L", "");
		newValue = newValue.replace("R","");
		newValue = newValue.replace("M", "");
		
		if (newValue.trim().length() != 0) {
			return false;
		}
		
		if (newValue.contains(" ")) {
			return false;
		}
		return true;
		
	}

}
