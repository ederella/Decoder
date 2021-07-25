package main.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing of GPSData: ")
public class GPSDataTest {

	@Test
	@DisplayName("toString() returns some string ")
	public void testToString() throws Exception {
		GPSData d = new GPSData();
		d.setAzimuth((short) 1 );
		d.setSpeed((short) 1 );
		d.setNumberOfDevices((byte) 1 );
		d.setHeight((short) 1 );
		d.setLatitude(10);
		d.setLongitude(20);
		assertNotNull(d.toString());
		assertThat(d.toString()).hasSizeGreaterThan(0);

	}

}
