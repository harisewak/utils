package com.techmorphosis.qube.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kamlesh on 028 28/11/15.
 */
public class SharedPrefUtils {

    public static void put(Context context, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, int value) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        return preferences.getBoolean(key, false);
    }

    public static int getInt(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        return preferences.getInt(key, -1);
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        return preferences.getString(key, null);
    }

    public static void remove(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void clearAll(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(Constants.USER_DATA, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public static boolean isLoggedIn(Context context) {
        if ((getString(context, "userId")) == null) {
            return false;
        } else {
            return true;
        }
    }

}
