package com.canuc80k.launcher;

import com.canuc80k.timer.CountdownClock;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Launcher extends Application {
    private Button picture, clock, laptop, speaker, glass;
    private CountdownClock countdownClock;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primeStage) {
        new Thread(() -> {
            countdownClock = new CountdownClock();
        }).start();

        primeStage.setTitle("dont_thirst_me_pls");
        primeStage.setResizable(false);
        primeStage.setWidth(500);
        primeStage.setHeight(500);

        Group group = new Group();  
        
        picture = new Button("Picture");
        picture.setLayoutX(100);
        picture.setLayoutY(100);
        picture.setPrefSize(50, 50);

        clock = new Button("Clock");
        clock.setLayoutX(100);
        clock.setLayoutY(200);
        clock.setPrefSize(50, 50);

        laptop = new Button("Laptop");
        laptop.setLayoutX(200);
        laptop.setLayoutY(100);
        laptop.setPrefSize(50, 50);

        speaker = new Button("Speaker");
        speaker.setLayoutX(200);
        speaker.setLayoutY(200);
        speaker.setPrefSize(50, 50);

        glass = new Button("Glass");
        glass.setLayoutX(150);
        glass.setLayoutY(300);
        glass.setPrefSize(50, 50);

        group.getChildren().addAll(picture, clock, laptop, speaker, glass);

        Scene scene = new Scene(group, 200, 300, Color.GRAY);  
        primeStage.setScene(scene);  
        primeStage.show();

        primeStage.onCloseRequestProperty().addListener(e -> {
            countdownClock.stop();
        });
    }
}