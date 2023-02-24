package com.canuc80k.clock;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class ExtendedClock extends Clock {
    Thread countdownThread;
    boolean isRunning = true;  
    long waitTimeInMilliSeconds = 5000;

    public ExtendedClock() {
        super();
    }

    public void start() {
        try {
            Thread.sleep(waitTimeInMilliSeconds);
            if (isRunning) {
                notifyTask();
                start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } 

    public void stop() {
        isRunning = false;
        Thread.interrupted();
    }

    private void notifyTask() {
        System.out.println("aaaa");
    }

    @Override
    public ZoneId getZone() {
        throw new UnsupportedOperationException("Unimplemented method 'getZone'");
    }

    @Override
    public Clock withZone(ZoneId zone) {
        throw new UnsupportedOperationException("Unimplemented method 'withZone'");
    }

    @Override
    public Instant instant() {
        throw new UnsupportedOperationException("Unimplemented method 'instant'");
    }
}
