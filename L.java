package com.techmorphosis.qube.utils;


// Created by kamlesh on 9/4/16, 12:53 PM

import android.util.Log;

public class L {

	private static boolean shouldLog = true;

	public static void d(String TAG, String message) {
		if (shouldLog) {
			Log.d(TAG, message);
		}
	}

	public static void e(String TAG, String message) {
		if (shouldLog) {
			Log.d(TAG, message);
			Log.e(TAG, message);
		}
	}
}
