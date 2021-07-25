package main;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import main.entity.PackageData;
import main.service.DecoderService;
import main.service.DecoderServiceImpl;
import main.utility.Util;

public class Main {

	public static void main(String[] args) {
		
		ByteBuffer b = Util.hexStringToByteBuffer("080100000113fc208dff00209cca800f14f650006f00d60400040004030101150316030001460000015d0001");
		DecoderService ds = new DecoderServiceImpl();
		ArrayList<PackageData> pd = ds.decode(b);
		System.out.println(pd.toString());
	}

}
