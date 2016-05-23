package com.techmorphosis.qube.utils.interfaces;
// Created by kamlesh on 30/3/16, 9:31 PM 

import android.support.design.widget.Snackbar;


public interface SnackbarProvider {
	Snackbar getSnackbar(String message, int duration);
}
