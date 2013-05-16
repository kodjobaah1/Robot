package com.ni.test.validator;

import org.junit.Before;
import org.junit.Test;

import com.ni.test.validator.ValidatePosition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class ValidatePositionTest {
	
	ValidatePosition positionValidator;
	
	
	private ValidateLocation validateLocation;
	
	@Before
	public void setup() {
		positionValidator = new ValidatePosition();
	}
	
	@Test
	public void testForValidPosition() {
		String val = "1 2 N";
		
		Boolean res = positionValidator.validatePosition(val);
		
		assertThat(res,equalTo(true));	
	}
	
	@Test
	public void testForInvalidLocation() {
		
		String val = "-1 -2 N";
		Boolean res = positionValidator.validatePosition(val);
		assertThat(res,equalTo(false));	
	}
	@Test
	public void testGetLocation() {
		String val = "1 2 N";
		
		String pos = positionValidator.getLocation(val);
		
		assertThat(pos,equalTo("1 2"));
		
		
	}
	
	@Test
	public void testGetDirection() {
		
		String val = "1 2 N";
		
		String pos = positionValidator.getDirection(val);
		
		assertThat(pos,equalTo("N"));
	}
	

	
	

}
