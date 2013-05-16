package com.ni.test;

import org.junit.Before;
import org.junit.Test;

import com.ni.test.vo.Location;
import com.ni.test.vo.Position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

public class ProcessInputTest {
	
	private ProcessInput processInput;
	
	@Before
	public void setup() {
		 processInput = new ProcessInput();
	}
	
	@Test
	public void testValidUserInput() {
		
		String userInput  = "5 5\n"+
							"1 2 N\n"+
							"LMLMLMLMM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		
		RobotInstruction robotInstruction = processInput.processInput();
		Location upperRight = robotInstruction.getUpperRight();
		Position position = robotInstruction.getPosition();
		String movements = robotInstruction.getMovements();

		assertThat(movements,equalTo("LMLMLMLMM"));
		assertThat(upperRight.getX(),equalTo(5));
		assertThat(upperRight.getY(),equalTo(5));
		
		assertThat(position.getLocation(),notNullValue());
		assertThat(position.getLocation().getX(),equalTo(1));
		assertThat(position.getLocation().getY(),equalTo(2));
		
		assertThat(position.getDirection(),notNullValue());
		assertThat(position.getDirection(),equalTo(Direction.NORTH));
		
		
	}
	
	@Test
	public void testInvalidValidUserInput() {
		
		String userInput  = "5 5\n"+
							"1 2 d N\n"+
							"LMLMLMLMM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		
		RobotInstruction robotInstruction = processInput.processInput();
		
		assertThat(robotInstruction,nullValue());
		
	}
	
	

	@Test
	public void testMissingInputUserInput() {
		
		String userInput  = "5 5\n"+
							"\n"+
							"LMLMLMLMM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		
		RobotInstruction robotInstruction = processInput.processInput();
		
		assertThat(robotInstruction,nullValue());
		
	}
	
	@Test
	public void testWhenAllUserInputIsNotSupplied() {
		
		String userInput  = "\n"+
							"\n"+
							"\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		
		RobotInstruction robotInstruction = processInput.processInput();
		
		assertThat(robotInstruction,nullValue());
		
	}
	
	@Test
	public void testWhenAllUserInputSuppliedAreBlankLines() {
		
		String userInput  = " \n"+
							" \n"+
							" \n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		
		RobotInstruction robotInstruction = processInput.processInput();
		
		assertThat(robotInstruction,nullValue());
		
	}
}
