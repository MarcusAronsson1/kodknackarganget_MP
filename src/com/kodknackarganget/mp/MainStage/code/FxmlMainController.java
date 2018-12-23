package com.kodknackarganget.mp.MainStage.code;

import static com.kodknackarganget.mp.MainStage.code.Main.stage;

import com.kodknackarganget.mp.Project;
import com.kodknackarganget.mp.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.ArrayList;


public class FxmlMainController {

    @FXML
    private Button exitBtn;
    @FXML
    private Button memberBtn;
    @FXML
    private Button taskBtn;
    @FXML
    private Button homeBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private Pane changePane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ProgressBar prog;
    @FXML
    private Button but;
    @FXML
    private Button saveBtn;
    @FXML
    private Label budget;

    private Project project;

    public void setProg() {
        ArrayList<Task> taskList = project.getTasks();
        double numberOfCompletedTasks = 0;
        for(Task currentTask : taskList){
            if(currentTask.isCompleted()){
                numberOfCompletedTasks += 1.0;
            }
        }
        double progress = (numberOfCompletedTasks / taskList.size());
        prog.setProgress(progress);
    }

    public void setProject(Project project){
        this.project = project;
    }

    public void updateBudget(){
        budget.setText(project.getMoneyBudget()+"");
    }


    public void initialize() {

        but.setOnAction(e -> {
            setProg();
        });

        exitBtn.setOnAction(e -> stage.close());


        homeBtn.setOnAction(e -> {
            try {
                anchorPane.getChildren().clear();
                Parent home = FXMLLoader.load(getClass().getResource("../FXML/main.fxml"));
                anchorPane.getChildren().add(home);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        memberBtn.setOnAction(e -> {
            try {
                changePane.getChildren().clear();
                Parent member = FXMLLoader.load(getClass().getResource("../FXML/member.fxml"));
                changePane.getChildren().add(member);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        taskBtn.setOnAction(e -> {
            try {
                changePane.getChildren().clear();
                Parent task = FXMLLoader.load(getClass().getResource("../FXML/tasks.fxml"));
                changePane.getChildren().add(task);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        searchBtn.setOnAction(e -> {
            try {
                changePane.getChildren().clear();
                Parent search = FXMLLoader.load(getClass().getResource("../FXML/search.fxml"));
                changePane.getChildren().add(search);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }
}
