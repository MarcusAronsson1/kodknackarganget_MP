package com.kodknackarganget.mp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        final Button button = new Button();
        button.setText("Haj du");
        button.setOnAction((ActionEvent event) -> {
            // Printing Hello World! to the console
            System.out.println("Hello World!");
        });

        primaryStage.setTitle("Hello kodknäckargänget!");
        primaryStage.setScene(new Scene(button, 300, 275));
        primaryStage.show();

    }
    public static void main(String[] args) {
        readJSON loadProject = new readJSON();
        Project kodknackargangetProject = loadProject.loadJSON();
        kodknackargangetProject.loadProject();
        launch(args);
    }
}
