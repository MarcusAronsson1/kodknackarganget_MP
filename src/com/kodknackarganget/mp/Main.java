package com.kodknackarganget.mp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    private Project project;

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        project = new Project("Projekt", 1, 5, 500, 10000);

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("com/kodknackarganget/mp/popups/editProject.fxml"));
        Parent root = loader.load();

        //Parent root = FXMLLoader.load(getClass().getResource("popups/addRisk.fxml"));

        Controller controller = loader.getController();
        controller.setProject(this.project);

        controller.showCurrentProjectInfo();

        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.setOpacity(0.97);
        primaryStage.setMaximized(false);
        primaryStage.show();
        stage = primaryStage;

    }
    public static void main(String[] args) {
        readJSON loadProject = new readJSON();
        Project kodknackargangetProject = loadProject.loadJSON();
        kodknackargangetProject.loadProject();
        launch(args);
    }
}
