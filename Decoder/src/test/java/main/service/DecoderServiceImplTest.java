package main.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.entity.PackageData;
import main.utility.Util;

@DisplayName("Testing of DecoderServiceImpl: ")
public class DecoderServiceImplTest {

	@Test
	@DisplayName("decode(ByteBuffer) returns proper ArrayList<PackageData>: ")
	public void testDecode() throws Exception {
		String checkString = "080100000113fc208dff00209cca800f14f650006f00d60400040004030101150316030001460000015d0001";
		DecoderServiceImpl dsi = new DecoderServiceImpl();
		PackageData pd = dsi.decode(Util.hexStringToByteBuffer(checkString)).get(0);
 
		assertThat(pd.getCreationTime().toString()).isEqualTo("2007-07-25T06:46:38.335Z");
		assertThat(pd.getPriority()).isEqualTo(0);
		
		assertThat(pd.getGpsData().getLongitude().toString()).isEqualTo("25.3032016°E");
		assertThat(pd.getGpsData().getLatitude().toString()).isEqualTo("54.7146368°N");
		assertThat(pd.getGpsData().getAzimuth()).isEqualTo((short)214);
		assertThat(pd.getGpsData().getHeight()).isEqualTo((short)111);
		assertThat(pd.getGpsData().getNumberOfDevices()).isEqualTo((byte)4);
		assertThat(pd.getGpsData().getSpeed()).isEqualTo((byte)4);
		
		assertThat(pd.getIoData().getEventIOiD()).isEqualTo((byte)0);
		assertThat(pd.getIoData().getNumberOfTotalIO()).isEqualTo((byte)4);
		assertThat(pd.getIoData().getData1Byte().toString()).isEqualTo("[Sensor: 1; value: 1, Sensor: 21; value: 3, Sensor: 22; value: 3]");
		assertThat(pd.getIoData().getData2Byte().size()).isEqualTo(0);
		assertThat(pd.getIoData().getData4Byte().toString()).isEqualTo("[Sensor: 70; value: 349]");
		assertThat(pd.getIoData().getData8Byte().size()).isEqualTo(0);
	}
}
