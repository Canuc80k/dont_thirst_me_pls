package com.canuc80k.display;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TimeCustomStage extends Stage {
    private Button background, submitButton;
    private TextField textField;

    public void create_window() {
        setTitle("dont_thirst_me_pls");
        setResizable(false);
        setWidth(400);
        setHeight(200);

        Group group = new Group();
        
        textField = new TextField();
        textField.setLayoutX(0);
        textField.setLayoutY(0);
        textField.setPrefWidth(200);
        textField.setPrefHeight(100);

        submitButton = new Button();
        textField.setLayoutX(0);
        textField.setLayoutY(100);
        textField.setPrefWidth(50);
        textField.setPrefHeight(50);

        background = new Button();
        background.setLayoutX(-10);
        background.setLayoutY(-10);
        background.setGraphic(
            new ImageView( 
                new Image(
                    HomeStage.class.getResourceAsStream("/design/background.png")
                )
            )
        );

        group.getChildren().addAll(background, textField, submitButton);

        Scene scene = new Scene(group, 500, 500, Color.GRAY);
        setScene(scene);
    }
}
