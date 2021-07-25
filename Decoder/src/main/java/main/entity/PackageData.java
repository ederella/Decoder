package main.entity;

import java.time.Instant;

import lombok.Data;


@Data
public class PackageData {
	private Instant creationTime;
	private int priority;
	private GPSData gpsData;
	private IOData ioData;
	
	@Override
	public String toString() {
		return
				"Timestamp: " + creationTime.toString() + "\n" + 
				"Priority: " + priority + "\n" +
				"GPS data:\n" + gpsData.toString() + "\n" + 
				"IO-data:\n" + ioData.toString();				
	}
}
