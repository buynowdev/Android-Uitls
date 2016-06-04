package com.buynow.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络工具类
 * @author buynow
 *
 */
public class HttpTools {
	/**
	 * 下载文件
	 * @param downloadUrl 下载链接
	 * @param savePath 保存路径
	 * @param timeout 超时时间
	 * @throws IOException
	 */
	public static void downloadFile(String downloadUrl , String savePath,String fileName,int timeout) throws IOException{
		InputStream in = openGetConnect(downloadUrl, timeout);
		System.out.println(savePath);
		File saveDir = new File(savePath);
		if(!saveDir.isDirectory()){
			saveDir.delete();
			saveDir.mkdirs();
		}
		File saveFile = new File(savePath+fileName);
		OutputStream os = new FileOutputStream(saveFile);
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len=in.read(buffer))>0){
			os.write(buffer, 0, len);
		}
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
	
	//demo
	public static void main(String[] args) {
		try {
			downloadFile("http://119.29.241.112:8080/buynow/myAppData/FanSafe/app.apk", "."+File.separatorChar+"cache"+File.separatorChar,"new.apk", 5000);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
