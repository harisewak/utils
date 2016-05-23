package com.techmorphosis.qube.utils.threads;


import com.techmorphosis.qube.utils.GeneralUtils;
import com.techmorphosis.qube.utils.interfaces.OnTimeOutListener;

/**
 * Created by Kamlesh on 002 02/10/15.
 */
public class TimerThread extends Thread {
    OnTimeOutListener timeOutListener;
    int secsCount;

    public TimerThread(int secsCount, OnTimeOutListener timeOutListener) {
        this.timeOutListener = timeOutListener;
        this.secsCount = secsCount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(secsCount * 1000);
            timeOutListener.onTimeOut();
        } catch (InterruptedException e) {
            GeneralUtils.print("TimerThread InterruptedEx");
            timeOutListener.onTimeOut();
        }
    }
}
