package main.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing of IOData: ")
public class IODataTest {

	@Test
	@DisplayName("toString() returns some string ")
	public void testToString() throws Exception {
		SensorData sd = mock(SensorData.class);
		IOData d = new IOData();
		d.setEventIOiD((byte)1);
		d.setNumberOfTotalIO((byte)4);
		d.getData1Byte().add(sd);
		d.getData2Byte().add(sd);
		d.getData4Byte().add(sd);
		d.getData8Byte().add(sd);
		
		assertNotNull(d.toString());
		assertThat(d.toString()).hasSizeGreaterThan(0);
	}

}
