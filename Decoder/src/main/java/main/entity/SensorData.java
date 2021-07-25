package main.entity;

import lombok.Data;
@Data
public class SensorData {
	private byte iD;
	private Number value;	

	@Override
	public String toString() {
		return "Sensor: " + iD + "; value: " + value;
				
	}	
	
}
