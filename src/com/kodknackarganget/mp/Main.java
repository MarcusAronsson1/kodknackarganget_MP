package com.kodknackarganget.mp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("popups/createMember.fxml"));

        //primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.setOpacity(0.97);
        primaryStage.setMaximized(false);
        primaryStage.show();
        stage = primaryStage;

    }


    public static void main(String[] args) {
        launch(args);
    }
}
