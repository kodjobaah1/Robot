package com.ni.test;


import java.util.HashMap;
import java.util.Map;

public enum Direction {
	
	NORTH(0), EAST(90),SOUTH(180), WEST(270);
	
	private int direction;
	
	private static Map<Integer, Direction> lookup;
	
	static {
		lookup = new HashMap<Integer,Direction>();
		for(Direction d: values()) {
			lookup.put(d.direction,d);
		}
	}
	private Direction(int direction) {
		this.direction = direction;
	}
	
	public static Direction getDirection(Integer i) {
		return lookup.get(i);
	}
	
	public Integer getValue() {
		return direction;
	}
	
}
