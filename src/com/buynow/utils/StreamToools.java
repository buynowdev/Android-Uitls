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
	
	/**
	 * 打开一个get方式请求
	 * 获得输入流
	 * @param urlStr 请求地址
	 * @param timeout 请求超时时间
	 * @return 从服务端获取的输入流
	 * @throws IOException 
	 */
	public static InputStream openGetConnect(String urlStr,int timeout) throws IOException{
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(timeout);
		int code = conn.getResponseCode();
		if(code == 200){
			InputStream in = conn.getInputStream();
			return in;
		}
		return null;
	}
	
	public static void main(String[] args){
		String urlStr = "http://119.29.241.112:8080/buynow/myAppData/FanSafe/FanSafe_update_info";
		try {
			InputStream in = openGetConnect(urlStr, 5000);
			String content= getString(in);
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
