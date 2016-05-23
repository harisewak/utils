package com.techmorphosis.qube.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;

// Created by kamlesh on 26/2/16, 12:59 PM

/* Useful in cases where onClick is not applicable to a ViewGroup because its children
* also receive touch events */

public class SingleTapListener extends GestureDetector.SimpleOnGestureListener {

    private Runnable runnable;

    public SingleTapListener(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        runnable.run();
        return true;
    }
}
