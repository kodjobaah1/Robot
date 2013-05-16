package com.ni.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoveRobotTest {
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void moveUpByOne() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"M\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 3 N\n"));
	}
	
	@Test
	public void invalidInput() {
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Invalid Robot Instructions");
		
		String userInput  = "5 5\n"+
				"-1 2 N\n"+
				"M\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();

	}
	
	@Test
	public void invalidMove() {
		
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("I can not go left anymore");
		
		String userInput  = "5 5\n"+
				"0 2 W\n"+
				"M\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
	}
	
	@Test
	public void moveUpByTwo() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"MM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 4 N\n"));
	}
	
	@Test
	public void moveDownByOne() {
		String userInput  = "5 5\n"+
				"1 2 S\n"+
				"M\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 1 S\n"));
	}
	
	@Test
	public void moveDownByTwo() {
		String userInput  = "5 5\n"+
				"1 2 S\n"+
				"MM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 0 S\n"));
	}
	
	@Test
	public void moveLeftByTwo() {
		String userInput  = "5 5\n"+
				"2 2 W\n"+
				"MM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("0 2 W\n"));
	}
	
	@Test
	public void moveLeftByOne() {
		String userInput  = "5 5\n"+
				"2 2 W\n"+
				"M\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 2 W\n"));
	}
	
	@Test
	public void moveRightByOne() {
		String userInput  = "5 5\n"+
				"2 2 E\n"+
				"M\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("3 2 E\n"));
	}
	
	@Test
	public void moveRightByTwo() {
		String userInput  = "5 5\n"+
				"2 2 E\n"+
				"MM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("4 2 E\n"));
	}
	
	@Test
	public void turnRobotLeft() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"L\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 2 W\n"));
	}
	
	@Test
	public void turnRobotRight() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"R\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 2 E\n"));
	}
	
	@Test
	public void turnRobotAroundFromRight() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"RR\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 2 S\n"));
	}
	
	@Test
	public void turnRobotAroundFromLeft() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"LL\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 2 S\n"));
	}
	
	
	
	@Test
	public void spinRobotAround() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"LLLL\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("1 2 N\n"));
	}
	
	@Test
	public void moveRobotFromNorthToSouthCounterClockWise() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"LMLM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("0 1 S\n"));
	}
	

	@Test
	public void moveRobotFromNorthToSouthClockWise() {
		String userInput  = "5 5\n"+
				"1 2 N\n"+
				"RMRM\n";

		System.setIn(new java.io.ByteArrayInputStream(userInput.getBytes()));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		MoveRobot moveRobot = new MoveRobot();
		
		moveRobot.moveRobot();
		
		String output = out.toString();
		assertThat(output,equalTo("2 1 S\n"));
	}

}
