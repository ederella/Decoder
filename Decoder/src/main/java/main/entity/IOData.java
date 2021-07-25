package main.entity;

import java.util.LinkedList;

import lombok.Data;
@Data
public class IOData {

	byte eventIOiD;
	byte numberOfTotalIO;
	
	LinkedList<SensorData> data1Byte = new LinkedList<SensorData>();
	LinkedList<SensorData> data2Byte = new LinkedList<SensorData>();
	LinkedList<SensorData> data4Byte = new LinkedList<SensorData>();
	LinkedList<SensorData> data8Byte = new LinkedList<SensorData>();

	@Override
	public String toString() {
		return data1Byte.toString() + data2Byte.toString() + data4Byte.toString() + data8Byte.toString();
	}
}
