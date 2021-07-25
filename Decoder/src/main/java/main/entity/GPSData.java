package main.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GPSData {
	public static final double GEO_PRECISION = 10000000d;
	private Geo longitude;
	private Geo latitude;
	private short height;
	private short azimuth;
	private byte numberOfDevices;
	private short speed;
	
	public void setLatitude(int value) {
		latitude = new Geo(value/GEO_PRECISION, Geo.CoordinateType.LATITUDE);
	}
	public void setLongitude(int value) {
		longitude = new Geo(value/GEO_PRECISION, Geo.CoordinateType.LONGITUDE);
	}

	@Override
	public String toString() {
		return "longitude: " + longitude.toString() + "\n" +
				"latitude: " + latitude.toString() + "\n" +
				"height: " + height + " meters" + "\n" + 
				"azimuth: " + azimuth + "\u00B0\n" + 
				"number of sputniks: " + numberOfDevices + "\n" +
				"speed: " + speed + " km/h";
	}
}
