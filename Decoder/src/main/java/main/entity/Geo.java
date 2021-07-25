package main.entity;

public class Geo {

	private double coordinate;
	private CoordinateType type;
	private static final char DEGREE = '\u00B0';
	
	public Geo(double coordinate, CoordinateType type) {
		this.coordinate = coordinate;
		this.type = type;
	}
	
	@Override
	public String toString() {
		Double unsignedCoord = Math.abs(coordinate);
		String eoString = "";
		if(type == CoordinateType.LATITUDE) {
			eoString = coordinate >= 0? "N" : "S";
		}else if(type == CoordinateType.LONGITUDE){
			eoString = coordinate >= 0? "E" : "W";
		}

		return unsignedCoord.toString() + DEGREE + eoString;
	}
	
	public static enum CoordinateType {
		LATITUDE,
		LONGITUDE
	}
}
