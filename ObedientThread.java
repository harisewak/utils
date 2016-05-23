package com.techmorphosis.qube.utils.threads;


import com.techmorphosis.qube.utils.interfaces.TimeOutResponder;

/**
 * Created by Kamlesh on 003 03/12/15.
 */
public class ObedientThread extends Thread {
    private int timeOutSecs;
    private TimeOutResponder responder;
    private Runnable runnable;

    private ObedientThread(Runnable runnable) {
        this.timeOutSecs = timeOutSecs;
        this.responder = responder;
        this.runnable = runnable;
    }

    public static ObedientThread getInstance(Runnable runnable) {
        return new ObedientThread(runnable);
    }

    @Override
    public void run() {
        runnable.run();
    }
}
