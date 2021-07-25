package main.utility;

import java.nio.ByteBuffer;

public class Util {

    public static ByteBuffer hexStringToByteBuffer(final String hex) {
    	if(hex!= null) {
	        byte[] bytes = hexStringToByteArray(hex);
	        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
	        buffer.put(bytes);
	        buffer.position(0);
	        return buffer;
    	}
    	else return null;
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    public static String bytesToHex(byte[] bytes) {
    	final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
