package com.canuc80k.launcher;

import com.canuc80k.state.ActiveState;
import com.canuc80k.timer.CountdownClock;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Launcher extends Application {
    private Button background, picture, clock, laptop, speaker, glass;
    private CountdownClock countdownClock;

    public static void main(String[] args) {
        StarterSetup.init();
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
        
        picture = new Button();
        picture.setLayoutX(20);
        picture.setLayoutY(10);
        picture.setGraphic(
            new ImageView( 
                new Image(
                    Launcher.class.getResourceAsStream("/design/picture.png")
                )
            )
        );
        picture.setBackground(null);

        clock = new Button();
        clock.setLayoutX(397);
        clock.setLayoutY(20);        
        clock.setGraphic(
            new ImageView( 
                new Image(
                    Launcher.class.getResourceAsStream("/design/clock.png")
                )
            )
        );
        clock.setBackground(null);

        laptop = new Button();
        laptop.setLayoutX(249);
        laptop.setLayoutY(100);
        laptop.setGraphic(
            new ImageView( 
                new Image(
                    Launcher.class.getResourceAsStream("/design/laptop.png")
                )
            )
        );
        laptop.setBackground(null);

        speaker = new Button();
        speaker.setLayoutX(140);
        speaker.setLayoutY(98);
        speaker.setGraphic(
            new ImageView( 
                new Image(
                    Launcher.class.getResourceAsStream("/design/speaker.png")
                )
            )
        );
        speaker.setBackground(null);

        glass = new Button();
        glass.setLayoutX(156);
        glass.setLayoutY(252);
        glass.setGraphic(
            new ImageView( 
                new Image(
                    Launcher.class.getResourceAsStream("/design/glass.png")
                )
            )
        );
        glass.setBackground(null);
        background = new Button();
        background.setLayoutX(-10);
        background.setLayoutY(-10);
        background.setGraphic(
            new ImageView( 
                new Image(
                    (ActiveState.getActiveState()) ? 
                        Launcher.class.getResourceAsStream("/design/background_on.png") :
                        Launcher.class.getResourceAsStream("/design/background_off.png")
                )
            )
        );
        background.setBackground(null);
        background.setOnAction(e -> {
            updateBackgroundUI();
        });
        group.getChildren().addAll(background, picture, clock, laptop, speaker, glass);

        Scene scene = new Scene(group, 500, 500, Color.GRAY);
        primeStage.setScene(scene);  
        primeStage.show();

        primeStage.onCloseRequestProperty().addListener(e -> {
            countdownClock.stop();
        });
    }

    
    public void updateBackgroundUI() {
        ActiveState.updateActiveState();
        boolean activeState = ActiveState.getActiveState();

        if (activeState) {
            background.setGraphic(
                new ImageView( 
                    new Image(
                        Launcher.class.getResourceAsStream("/design/background_on.png")
                    )
                )
            ); 
        } else {
            background.setGraphic(
                new ImageView( 
                    new Image(
                        Launcher.class.getResourceAsStream("/design/background_off.png")
                    )
                )
            );
        }
    }
}