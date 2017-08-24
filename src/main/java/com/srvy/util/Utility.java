package com.srvy.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class Utility {
	
	public static Sha256Hex SHA256HEX = new Sha256Hex();

	public static <T> boolean isNullOrEmpty(List<T> list){
		return (list == null || list.isEmpty());
	}
	
	public static <K,V> boolean isNullOrEmpty(Map<K,V> map){
		return (map == null || map.isEmpty());
	}
	
	public static String randomUUID(){
		return UUID.randomUUID().toString();
	}


	/**
	 * Used to print the exception
	 * @param Exception
	 */
	public static String printLog(Exception e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		Logger.getLogger("LOG").warning(writer.toString());
		return writer.toString();
	}
	

	/**
	 * This function returns converted string from stream
	 * @param InputStream
	 * @return
	 */
	public static String getString(InputStream stream)  {
		try {
			return new String(getBytes(stream),"UTF-8");
		} catch (IOException e) {
			printLog(e);
		}
		return "";
	}
	
	/**
	 * This function used to convert InputStream to bytes array
	 * @param InputStream
	 * @return converted bytes array
	 * @throws IOException
	 */
	public static byte[] getBytes(InputStream stream) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();		
		int nRead;
		byte[] data = new byte[1024];
		while ((nRead = stream.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}
		buffer.flush();
		return buffer.toByteArray();
	}
	
	
}
