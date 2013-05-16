package com.ni.test.validator;

import org.junit.Test;

import com.ni.test.validator.ValidateLocation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidateLocationTest {
	
	@Test
	public void testValidLocation() {
		
		ValidateLocation validateLocation = new ValidateLocation();
		
		String val = " 1 1 ";
		
		Boolean res = validateLocation.validateLocation(val);
		
		assertThat(res,equalTo(true));
	}
	
	
	@Test
	public void testForLeftInvalidLocation() {
		
		ValidateLocation validateLocation = new ValidateLocation();
		
		String val = " -1 1 ";
		
		Boolean res = validateLocation.validateLocation(val);
		
		assertThat(res,equalTo(false));
	}
	
	
	@Test
	public void testForRightInvalidLocation() {
		
		ValidateLocation validateLocation = new ValidateLocation();
		
		String val = " 1 -1 ";
		
		Boolean res = validateLocation.validateLocation(val);
		
		assertThat(res,equalTo(false));
	}
	
	@Test
	public void testLocationWithOneCharacter() {
		
		ValidateLocation validateLocation = new ValidateLocation();
		
		String val = "M 1";
		
		Boolean res = validateLocation.validateLocation(val);
		
		assertThat(res,equalTo(false));
	}

	@Test
	public void testLocationWithTwoCharacter() {
		
		ValidateLocation validateLocation = new ValidateLocation();
		
		String val = "M d";
		
		Boolean res = validateLocation.validateLocation(val);
		
		assertThat(res,equalTo(false));
	}
	
	@Test
	public void testLocationWithWrongNumber0fValues() {
		
		ValidateLocation validateLocation = new ValidateLocation();
		
		String val = "M d d ";
		
		Boolean res = validateLocation.validateLocation(val);
		
		assertThat(res,equalTo(false));
	}
}
