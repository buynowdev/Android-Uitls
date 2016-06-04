package com.buynow.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import java.net.HttpURLConnection;

/**
 * 流处理
 * @author buynow
 */
public class StreamToools {
	/**
	 * 输入流转字符串
	 * @param in 输入流
	 * @return 字符串
	 */
	public static String getString(InputStream in){
		InputStreamReader isr = new InputStreamReader(in);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] array = new byte[1024];
		int len = 0;
		try {
			while((len = in.read(array))>0){
				baos.write(array, 0, len);
			}
			return baos.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	
}
