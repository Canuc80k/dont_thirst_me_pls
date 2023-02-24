package com.canuc80k.timer;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownClock {
    Timer timer;
    
    public CountdownClock() {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aaaa");
            }
        }, 0, 2000);
    }

    public void stop() {
        timer.cancel();
        timer.purge();
    }
}
