package com.buynow.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by buynow on 16-6-4. 
 * 对SharedPreferences的封装 
 * 以key-value保存数据和读取数据
 */
public class SPUtils {

	public static boolean getBoolean(Context context, String key,
			boolean defValue) {
		SharedPreferences mSP = context.getSharedPreferences(
				MyConstants.SP_FILE_NAME, Context.MODE_PRIVATE);
		return mSP.getBoolean(key, defValue);
	}

	public static void putBoolean(Context context, String key, boolean value) {
		SharedPreferences mSP = context.getSharedPreferences(
				MyConstants.SP_FILE_NAME, Context.MODE_PRIVATE);
		mSP.edit().putBoolean(key, value).commit();
	}

	public static String getString(Context context, String key) {
		SharedPreferences mSP = context.getSharedPreferences(
				MyConstants.SP_FILE_NAME, Context.MODE_PRIVATE);
		return mSP.getString(key, null);
	}

	public static void putString(Context context, String key, String value) {
		SharedPreferences mSP = context.getSharedPreferences(
				MyConstants.SP_FILE_NAME, Context.MODE_PRIVATE);
		mSP.edit().putString(key, value).commit();
	}

	public static int getInteger(Context context, String key) {
		SharedPreferences mSP = context.getSharedPreferences(
				MyConstants.SP_FILE_NAME, Context.MODE_PRIVATE);
		return mSP.getInt(key, 0);
	}

	public static void putInteger(Context context, String key, int value) {
		SharedPreferences mSP = context.getSharedPreferences(
				MyConstants.SP_FILE_NAME, Context.MODE_PRIVATE);
		mSP.edit().putInt(key, value).commit();
	}

}
