package com.canuc80k.timer;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CountdownClock {
    Timer timer;
    private int delayInMs = 5000;  
    
    public CountdownClock() {
        timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Stage secondStage = new Stage();
                    secondStage.setScene(new Scene(new HBox(4, new Label("Second window"))));
                    secondStage.show();
                });
            }
        }, delayInMs, delayInMs);
    }

    public void stop() {
        timer.cancel();
        timer.purge();
    }

    public int getDelayInMs() {
        return delayInMs;
    }

    public void setDelayInMs(int delay) {
        delayInMs = delay;
    }
}
