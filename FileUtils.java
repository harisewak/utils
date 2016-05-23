package com.techmorphosis.qube.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.techmorphosis.qube.utils.interfaces.ServerImageResponseListener;
import com.techmorphosis.qube.utils.networkutils.NetworkUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by karthik on 01-02-2016.
 */
public class FileUtils {
    private static final String TAG = "FileUtils";

    /**
     * @param sourceLocation
     * @param targetLocation
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static boolean copy(File sourceLocation, File targetLocation) {
        boolean status = true;
        try {
            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            status = false;
        }
        return status;
    }

    public static void deleteFiles(File directory) {
        if (directory.exists() && directory.isDirectory()) {
            if (directory.listFiles() != null && directory.listFiles().length > 0) {
                for (File child : directory.listFiles()) {
                    child.delete();
                }
            }
            directory.delete();
        }
    }

    /*Save using volley library*/
    public static boolean save(Context context, String url, final String filePath) {
        boolean status = true;

        try {
            new NetworkUtils(context, new ServerImageResponseListener() {
                @Override
                public void onServerResponse(Bitmap response) {
                    try {
                        FileOutputStream out = new FileOutputStream(filePath);
                        response.compress(Bitmap.CompressFormat.JPEG, 10, out);
                    } catch (IOException e) {
                        Log.e(TAG, "save: ", e);
                    }
                }
            }).makeImageRequest(url);
        } catch (Exception e) {
            Log.e(TAG, "save: ", e);
            status = false;
        }
        return status;
    }

    /*Saving using HttpURlConnection. This method will block the calling thread
    * as it will wait for the server response on the same thread. It should NOT be
    * called from main/UI thread. Preferably, called from a worker or some other thread*/
    public static boolean save(String url, String filePath) {
        boolean status = true;
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int length;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            BufferedInputStream in = new BufferedInputStream((connection.getInputStream()), bufferSize);
            FileOutputStream out = new FileOutputStream(filePath);
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (Exception e) {
            Log.e(TAG, "save: ", e);
            status = false;
        }
        return status;
    }
}
