package com.canuc80k.launcher;

import com.canuc80k.display.HomeStage;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        StarterSetup.init();

        launch(args);
    }

    @Override
    public void start(Stage primeStage) {
        HomeStage homeStage = new HomeStage();
        homeStage.create_window();
        homeStage.startCountdownClockInNewThread();

        primeStage = homeStage;
        primeStage.show();
    }
}