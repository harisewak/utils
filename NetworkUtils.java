package com.techmorphosis.qube.utils.networkutils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.techmorphosis.qube.utils.interfaces.OnServerResponseListener;
import com.techmorphosis.qube.utils.interfaces.ServerImageResponseListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Base class for making network requests (currently only deals with string requests)
public class NetworkUtils {
	// string literals
	private static final String os = Build.VERSION.RELEASE;
	private static final String make = Build.MANUFACTURER;
	private static final String model = Build.MODEL;
	private static final long TIMEOUT_MS = 20000;
	private ServerImageResponseListener imageResListener;
	private Context context;
	private RequestQueue queue;
	// Listener to handle server response.
	private OnServerResponseListener serverResListener;
	// own progress dialog to simplify implementation
	private ProgressDialog prDialog;
	private boolean hasTimedOut;
	private static final String TAG = "NetworkUtils";

	/* Constructor starts a new queue every time it is called. This queue is stopped
	* when 'error' or 'success' is encountered. */
	public NetworkUtils(Context context, OnServerResponseListener serverResListener) {
		this.context = context;
//		queue = getRequestQueue();
		queue = VolleySingleton.getInstance(context.getApplicationContext()).getRequestQueue();
		this.serverResListener = serverResListener;
		prDialog = new ProgressDialog(context);
		prDialog.setCancelable(false);
		prDialog.setCanceledOnTouchOutside(false);
	}

	public NetworkUtils(Context context, ServerImageResponseListener serverResListener) {
		this.context = context;
//		queue = getRequestQueue();
		queue = VolleySingleton.getInstance(context).getRequestQueue();
		this.imageResListener = serverResListener;
		prDialog = new ProgressDialog(context);
		prDialog.setCancelable(false);
	}

	// actual work is done here. It takes URL and Params (as HashMap)
	public void makeRequest(String url, final HashMap<String, String> keyValuePairs) {
		hasTimedOut = true;
		// initiate progress dialog
		prDialog.setMessage("connecting...");
		prDialog.show();
	     /* create request. Requires 'success' and 'error' listeners. Also, getParams()
            is overridden to allow accepting Params */
		StringRequest request = new StringRequest(StringRequest.Method.POST, url, successListener(), errorListener()) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				keyValuePairs.put("os", os);
				keyValuePairs.put("make", make);
				keyValuePairs.put("model", model);
				// printing parameters sent to server.
				Thread printer = new Thread(new Runnable() {
					@Override
					public void run() {
						Set<String> keys = keyValuePairs.keySet();
						for (String key :
								keys) {
							Log.d(TAG, "parameter : " + key + ", value : " + keyValuePairs.get(key));
						}
					}
				});
				printer.start();
				return keyValuePairs;
			}
		};
		// add request to queue.
		queue.add(request);
		handleServerTimeOut();
	}

	public void makeRequestWithoutProgressBar(String url, final HashMap<String, String> keyValuePairs) {
		hasTimedOut = true;
         /* create request. Requires 'success' and 'error' listeners. Also, getParams()
            is overridden to allow accepting Params */
		StringRequest request = new StringRequest(StringRequest.Method.POST, url, successListener(), errorListener()) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				keyValuePairs.put("os", os);
				keyValuePairs.put("make", make);
				keyValuePairs.put("model", model);
				return keyValuePairs;
			}
		};
		// add request to queue.
		queue.add(request);
		handleServerTimeOut();
	}


	public void makeImageRequest(String url) {
		hasTimedOut = true;
		ImageRequest request = new ImageRequest(url, imageSuccessListener(), 0, 0, ImageView.ScaleType.CENTER_INSIDE, null, imageErrorListener());
		// add request to queue.
		queue.add(request);
	}

	public void makeImageRequestWithoutCaching(String url) {
		queue.getCache().remove(url);
		hasTimedOut = true;
		ImageRequest request = new ImageRequest(url, imageSuccessListener(), 0, 0, ImageView.ScaleType.CENTER_INSIDE, null, imageErrorListener());
		// add request to queue.
		queue.add(request);
	}

	private Response.Listener<Bitmap> imageSuccessListener() {
		return new Response.Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				if (imageResListener != null) {
					if (context != null) {
						imageResListener.onServerResponse(response);
					}
				}
			}
		};
	}

	private Response.ErrorListener imageErrorListener() {
		return new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO: 8/2/16 if required, handle error response for Image Listener.
			}
		};
	}

	private void handleServerTimeOut() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (hasTimedOut) {
//					queue.cancelAll(new RequestQueue.RequestFilter() {
//						@Override
//						public boolean apply(Request<?> request) {
//							return true;
//						}
//					});
//					queue.stop();
					if (serverResListener != null) {
						serverResListener.onServerResponse("error");
					}
					prDialog.dismiss();
				}
			}
		}, TIMEOUT_MS);

	}

	/* returns error listener. Call your server Response Handler here.
//	* Dismiss progress dialog and stop queue. */
	private Response.ErrorListener errorListener() {
		return new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.d(TAG, "errorListener: " + error.toString());

				hasTimedOut = false;
				if (serverResListener != null) {
					if (context != null) {
						serverResListener.onServerResponse("error");
					}
					Log.d(TAG, "errorListener: " + "below onServerResponse");
				}
				prDialog.dismiss();
//				queue.stop();
			}
		};
	}

	/* returns success listener. Call your server Response Handler here.
	* Dismiss progress dialog and stop queue. */
	private Response.Listener<String> successListener() {
		return new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				hasTimedOut = false;
				if (serverResListener != null) {
					if (context != null) {
						serverResListener.onServerResponse(response);
					}
				}
				if (prDialog != null && prDialog.isShowing()) {
					prDialog.dismiss();
				}
//				queue.stop();
			}
		};
	}

	public RequestQueue getRequestQueue() {
		Cache cache = new DiskBasedCache(context.getCacheDir(), 10 * 1024 * 1024);
		Network network = new BasicNetwork(new HurlStack());
		RequestQueue requestQueue = new RequestQueue(cache, network);
		// Don't forget to start volley request queue
		requestQueue.start();
		return requestQueue;
	}
}
