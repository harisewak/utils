package com.techmorphosis.qube.utils.threads;

import android.os.Handler;
import android.os.HandlerThread;


// Created by kamlesh on 1/3/16, 5:36 PM

/* A worker thread for offloading heavy work so as to keep UI thread responsive
* and smooth */
public class Worker extends HandlerThread {
    public final String NAME = "Worker";
    private Handler handler;

    public Worker(String name, int priority) {
        super(name, priority);
    }

    public Worker(int priority) {
        super("Worker", priority);
    }

    public Worker() {
        super("Worker", HandlerThread.NORM_PRIORITY);
    }

    public void prepareHandler() {
        handler = new Handler(getLooper());
    }

    // do some work in background
    public void doWork(Runnable someWork) {
        prepareHandler();
        handler.post(someWork);
    }
}
