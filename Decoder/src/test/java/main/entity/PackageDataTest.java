package main.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
@DisplayName("Testing of PackageData: ")
public class PackageDataTest {

	@Test
	@DisplayName("toString() returns some string ")
	public void testToString() throws Exception {
		PackageData pd = new PackageData();
		pd.setCreationTime(Instant.now());
		pd.setPriority(0);
		pd.setGpsData(mock(GPSData.class));
		pd.setIoData(mock(IOData.class));
		assertNotNull(pd.toString());
		assertThat(pd.toString()).hasSizeGreaterThan(0);
	}

}
