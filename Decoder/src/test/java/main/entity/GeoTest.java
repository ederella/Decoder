package main.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Testing of Geo: ")
public class GeoTest {

	@Test
	@DisplayName("toString() returns some string")
	public void testToString() throws Exception {
		Geo geo = new Geo(10.123, Geo.CoordinateType.LATITUDE);
		assertNotNull(geo.toString());
		assertThat(geo.toString()).hasSizeGreaterThan(0);
	}

}
