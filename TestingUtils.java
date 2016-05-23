package com.techmorphosis.qube.utils;

// Created by kamlesh on 26/2/16, 7:16 PM

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Testing utility methods */
public class TestingUtils {

    private static final String TAG = "TestingUtils";


    public static String getTestResponse(Context context) {
        String line = "";
        StringBuilder sb = new StringBuilder();
        try {
            InputStreamReader reader = new InputStreamReader(context.getAssets().open("test.json"));
            BufferedReader bufferedReader = new BufferedReader(reader, 1024);

            int character = 0;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
//                line += line;
            }
        } catch (IOException e) {
            Log.d(TAG, "getTestResponse() called with: " + "");
        }
        return sb.toString();
    }
}
