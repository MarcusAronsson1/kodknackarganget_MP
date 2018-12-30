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
    private Project project;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.project = new Project("projekt", 1, 5, 500, 99999);
        this.project = project.loadProject();
        System.out.println(project.getName());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/main.fxml"));
        Parent root = loader.load();

        FxmlMainController controller = loader.getController();
        controller.setProject(this.project);
        controller.updateBudget();

        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.setOpacity(1);
        primaryStage.show();
        stage = primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
