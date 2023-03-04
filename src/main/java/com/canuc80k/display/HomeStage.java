package com.canuc80k.display;

import com.canuc80k.state.ActiveState;
import com.canuc80k.timer.CountdownClock;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeStage extends Stage {
    private Button background, picture, clock, laptop, speaker, glass;
    private CountdownClock countdownClock;

    public void create_window() {
        setTitle("dont_thirst_me_pls");
        setResizable(false);
        setWidth(500);
        setHeight(500);

        Group group = new Group();  
        
        picture = new Button();
        picture.setLayoutX(20);
        picture.setLayoutY(10);
        picture.setGraphic(
            new ImageView( 
                new Image(
                    HomeStage.class.getResourceAsStream("/design/picture.png")
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
                    HomeStage.class.getResourceAsStream("/design/clock.png")
                )
            )
        );
        clock.setOnAction(e -> {
            TimeCustomStage timeCustomStage = new TimeCustomStage();
            timeCustomStage.create_window();

            timeCustomStage.show();
        });
        clock.setBackground(null);

        laptop = new Button();
        laptop.setLayoutX(249);
        laptop.setLayoutY(100);
        laptop.setGraphic(
            new ImageView( 
                new Image(
                    HomeStage.class.getResourceAsStream("/design/laptop.png")
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
                    HomeStage.class.getResourceAsStream("/design/speaker.png")
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
                    HomeStage.class.getResourceAsStream("/design/glass.png")
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
                        HomeStage.class.getResourceAsStream("/design/background_on.png") :
                        HomeStage.class.getResourceAsStream("/design/background_off.png")
                )
            )
        );
        background.setBackground(null);
        background.setOnAction(e -> {
            updateBackgroundUI();
        });
        group.getChildren().addAll(background, picture, clock, laptop, speaker, glass);

        Scene scene = new Scene(group, 500, 500, Color.GRAY);
        setScene(scene);  
        show();

        onCloseRequestProperty().addListener(e -> {
            countdownClock.stop();
        });
    }

    public void updateBackgroundUI() {
        ActiveState.updateActiveState();
        boolean activeState = ActiveState.getActiveState();

        if (activeState) {
            countdownClock = new CountdownClock();
            background.setGraphic(
                new ImageView( 
                    new Image(
                        HomeStage.class.getResourceAsStream("/design/background_on.png")
                    )
                )
            ); 
        } else {
            countdownClock.stop();
            background.setGraphic(
                new ImageView( 
                    new Image(
                        HomeStage.class.getResourceAsStream("/design/background_off.png")
                    )
                )
            );
        }
    }

    public void startCountdownClockInNewThread() {
        new Thread(() -> {
            if (ActiveState.getActiveState()) countdownClock = new CountdownClock();
        }).start();
    }
}
