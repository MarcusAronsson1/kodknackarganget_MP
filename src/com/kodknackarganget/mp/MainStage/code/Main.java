package com.kodknackarganget.mp.MainStage.code;
import com.kodknackarganget.mp.Project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;


public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/main.fxml"));
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.show();
        stage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
