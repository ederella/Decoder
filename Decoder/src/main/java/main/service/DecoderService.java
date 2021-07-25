package main.service;

import java.util.ArrayList;

import main.entity.PackageData;

public interface DecoderService {

	ArrayList<PackageData> decode(java.nio.ByteBuffer packageDataByteBuffer);

}
