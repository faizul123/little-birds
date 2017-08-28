package com.srvy.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Utility {
	
	public static Sha256Hex SHA256HEX = new Sha256Hex();
	
	public static final int MAX_LIMIT = 10;

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
	
	public static String toSlug(String content){
		content = content.trim().toLowerCase();
		content = Normalizer.normalize(content, Form.NFD);
		Pattern NONLATIN_without_hyphen = Pattern.compile("[^\\w]");
		Pattern NONLATIN = Pattern.compile("[^\\w-]");
		Pattern WHITESPACE = Pattern.compile("[\\s]");
		String[] words = content.split(" ");
		ArrayList<String> resultWords = new ArrayList<String>();
		int length = words.length;
		int index = 0;
		for (String s : words) {
	
			if (index < length) {
				s = NONLATIN_without_hyphen.matcher(s).replaceAll("");
				String withoutspaces = "";
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) != ' ')
						if (s.charAt(i) != '_')
							withoutspaces += s.charAt(i);
				}
	
				if (withoutspaces != "") {
					resultWords.add(withoutspaces);
				}
				index++;
			}
	
		}
		content = "";
		for (String text : resultWords) {
			content += text + " ";
		}
		content = WHITESPACE.matcher(content).replaceAll("-");
		content = NONLATIN.matcher(content).replaceAll("");
		content = content.substring(0,content.length()-1);
		return content;	
	}

	public static int getOffSet(int pageNumber,int limit){
		limit = checkLimit(limit);
		if (pageNumber < 0) {
			pageNumber = 1;
		}
		
		return (pageNumber - 1) * limit;
	}
	
	public static int checkLimit(int limit){
		if (limit > MAX_LIMIT){
			limit = MAX_LIMIT;
		}
		return limit;
	}
	
	
}
