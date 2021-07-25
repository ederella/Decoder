package main.service;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Supplier;

import main.entity.GPSData;
import main.entity.IOData;
import main.entity.PackageData;
import main.entity.SensorData;

public class DecoderServiceImpl implements DecoderService{

	private ByteBuffer packageDataByteBuffer;
	
	public ArrayList<PackageData> decode(ByteBuffer packageDataByteBuffer) {
		this.packageDataByteBuffer = packageDataByteBuffer;
		
		if (this.packageDataByteBuffer != null && this.packageDataByteBuffer.capacity() > 0) {
			
			byte codecID = packageDataByteBuffer.get();
			byte numberOfRecords = packageDataByteBuffer.get();

			ArrayList<PackageData> packageDataArr = new ArrayList<PackageData>(numberOfRecords);

			for (byte i = 0; i < numberOfRecords; i++) {
				packageDataArr.add(decodeEntry());
			}

			return packageDataArr;
		} else
			return null;
	}
	
	private PackageData decodeEntry() {
		
		PackageData packageData = new PackageData();
		long times = getNextLong();
		packageData.setCreationTime(Instant.ofEpochMilli(times));		
		packageData.setPriority(packageDataByteBuffer.get());
		
		GPSData gpsData = new GPSData();
		gpsData.setLatitude(getNextInt());
		gpsData.setLongitude(getNextInt());
		gpsData.setHeight(getNextShort());
		gpsData.setAzimuth(getNextShort());
		gpsData.setNumberOfDevices(packageDataByteBuffer.get());
		gpsData.setSpeed(getNextShort());		
		
		IOData ioData = new IOData();
		ioData.setEventIOiD(packageDataByteBuffer.get());
		ioData.setNumberOfTotalIO(packageDataByteBuffer.get());
		
		addSensors(ioData.getData1Byte(), () -> {
			return packageDataByteBuffer.get();
		});
		addSensors(ioData.getData2Byte(), () -> {
			return getNextShort();
		});
		addSensors(ioData.getData4Byte(), () -> {
			return getNextInt();
		});
		addSensors(ioData.getData8Byte(), () -> {
			return getNextLong();
		});
	
		packageData.setGpsData(gpsData);
		packageData.setIoData(ioData);
		
		return packageData;
	}

	private void addSensors(LinkedList<SensorData> data, Supplier<Number> method) {
		byte num = packageDataByteBuffer.get();		
		for(byte i = 0; i < num; i++) {	
			SensorData sensorData = new SensorData();
			sensorData.setID(packageDataByteBuffer.get());
			sensorData.setValue(method.get());
			data.add(sensorData);
		}
	}

	private byte[] getBytes(ByteBuffer packageDataByteBuffer, int len) {
		byte[] bytes = new byte[len];
		packageDataByteBuffer.get(bytes, 0, len);
		return bytes;
	}
	
	private long getNextLong() {
		return ByteBuffer.wrap(getBytes(this.packageDataByteBuffer, Long.BYTES)).getLong();
	}
	private short getNextShort() {
		return ByteBuffer.wrap(getBytes(this.packageDataByteBuffer, Short.BYTES)).getShort();
	}
	private int getNextInt() {
		return ByteBuffer.wrap(getBytes(this.packageDataByteBuffer, Integer.BYTES)).getInt();
	}

}
