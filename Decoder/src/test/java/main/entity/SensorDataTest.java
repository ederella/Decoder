package main.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Testing of SensorData: ")
public class SensorDataTest {

	@Test
	@DisplayName("toString() returns some string ")
	public void testToString() throws Exception {
		SensorData sd = new SensorData();
		sd.setID((byte) 1);
		sd.setValue(123);
		assertNotNull(sd.toString());
		assertThat(sd.toString()).hasSizeGreaterThan(0);
	}

}
