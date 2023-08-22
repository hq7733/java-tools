package com.htools.time;


import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

/**
 * @author hq
 * @date 2023/8/22
 */
public class TimerUtils {

    private Timer timer;
    private int seconds;

    public TimerUtils() {
        timer = new Timer();
        seconds = 0;
    }

    public void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        }, 1000, 1000);
    }

    public void stopTimer() {
        timer.cancel();
        seconds = 0;
    }

    public long interval() {
        return this.seconds;
    }

    public long intervalRestart() {
        long interim = this.seconds;
        this.stopTimer();
        this.startTimer();
        return interim;
    }
}
