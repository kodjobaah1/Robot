package com.ni.test.validator;

import org.junit.Before;
import org.junit.Test;

import com.ni.test.validator.ValidateMovement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidateMovementTest {
	
	private ValidateMovement movement;
	
	@Before
	public void setup() {
		movement = new ValidateMovement();
	}
	
	@Test
	public void validateGoodMoveTest() {
		String val = "llmmllLMllRr";
		
		Boolean res = movement.validateMovement(val);
		
		assertThat(res,equalTo(true));
		
	}
	
	@Test
	public void invalidateGoodMoveTest() {
		String val = "llmml lLMllRr";
		
		Boolean res = movement.validateMovement(val);
		
		assertThat(res,equalTo(false));
		
	}
	
	@Test
	public void invalidateBadMoveTest() {
		String val = "llmmllLMllRS";
		
		Boolean res = movement.validateMovement(val);
		
		assertThat(res,equalTo(false));
		
	}

}
