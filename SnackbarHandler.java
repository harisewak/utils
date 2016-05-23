package com.techmorphosis.qube.utils;
// Created by kamlesh on 4/4/16, 3:29 PM 

import android.support.design.widget.Snackbar;
import android.view.View;


public class SnackbarHandler {
	private static SnackbarHandler curInstance;
	private View rootView;

	private SnackbarHandler(View rootView) {
		this.rootView = rootView;
	}

	public static void create(View rootView) {
		curInstance = new SnackbarHandler(rootView);
	}

	public static void destroy() {
		curInstance = null;
	}

	public static boolean exists() {
		if (curInstance == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void show(String message, int duration, String btnText, View.OnClickListener onClickListener) {
		Snackbar.make(curInstance.rootView, message, duration).
				setAction(btnText, onClickListener).
				show();
	}

}
