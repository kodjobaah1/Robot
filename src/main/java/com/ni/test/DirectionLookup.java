package com.ni.test;

import java.util.HashMap;
import java.util.Map;

public final class DirectionLookup {
	
	private static Map<String,Direction> directionLookup;
	private static Map<Direction,String> directionType;
	
	static {
		directionLookup = new HashMap<String,Direction>();
		
		directionLookup.put("N", Direction.NORTH);
		directionLookup.put("S", Direction.SOUTH);
		directionLookup.put("E", Direction.EAST);
		directionLookup.put("W", Direction.WEST);		
	}
	
	static {
		directionType = new HashMap<Direction,String>();
		directionType.put(Direction.NORTH, "N");
		directionType.put(Direction.SOUTH,	"S");
		directionType.put(Direction.WEST, "W");
		directionType.put(Direction.EAST,"E");
	}
	
	public static Direction getDirection(String direction) {
		return directionLookup.get(direction.toUpperCase());
	}
	
	public static String getDirectionType(Direction direction) {
		return directionType.get(direction);
	}

}
