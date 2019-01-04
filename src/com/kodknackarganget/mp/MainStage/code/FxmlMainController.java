package com.kodknackarganget.mp.MainStage.code;

import com.kodknackarganget.mp.*;
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
    private Button ecoBtn;
    @FXML
    private Pane changePane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ProgressBar prog;
    @FXML
    private Label budget;
    @FXML
    private Label projectNameLabel;
    @FXML
    private Label startWeekLabel;
    @FXML
    private Label endWeekLabel;
    @FXML
    private Label risk1Label;
    @FXML
    private Label risk1Impact;
    @FXML
    private Label risk1Prob;
    @FXML
    private Label risk1Risk;
    @FXML
    private Label risk2Label;
    @FXML
    private Label risk2Impact;
    @FXML
    private Label risk2Prob;
    @FXML
    private Label risk2Risk;
    @FXML
    private Label risk3Label;
    @FXML
    private Label risk3Impact;
    @FXML
    private Label risk3Prob;
    @FXML
    private Label risk3Risk;
    @FXML
    private ProgressIndicator budgetIndicator;

    private Project project;

    public void updateAll(){
        updateProgress();
        updateBudget();
        updateProjectName();
        updateWeeks();
        updateRisks();
        updateBudgetIndicator();
    }

    public void updateProgress() {
        ArrayList<Task> taskList = project.getTasks();
        double numberOfCompletedTasks = 0;
        for(Task currentTask : taskList){
            if(currentTask.isCompleted()){
                numberOfCompletedTasks += 1.0;
            }
        }
        double progress = 1;
        if(taskList.size() > 0) {
            progress = (numberOfCompletedTasks / taskList.size());
        }else{
            progress = (numberOfCompletedTasks / 1);
        }
        prog.setProgress(progress);
    }

    public void updateBudget(){
        budget.setText(project.getMoneyBudget()+" SEK");
    }

    public void updateProjectName(){
        projectNameLabel.setText(this.project.getName());
    }

    public void updateWeeks(){
        startWeekLabel.setText("Week " + project.getStartWeek()+"");
        endWeekLabel.setText("Week " + project.getEndWeek()+"");
    }
    public void updateRisks(){
        ArrayList<Risk> risks = project.getRisks();
        Risk risk1 = risks.get(0);
        Risk risk2 = risks.get(1);
        Risk risk3 = risks.get(2);

        risk1Label.setText(risk1.getDescription());
        risk1Impact.setText(risk1.getImpact()+"");
        risk1Prob.setText(risk1.getProbability()+"");
        risk1Risk.setText(risk1.calculateRisk()+"");

        risk2Label.setText(risk2.getDescription());
        risk2Impact.setText(risk2.getImpact()+"");
        risk2Prob.setText(risk2.getProbability()+"");
        risk2Risk.setText(risk2.calculateRisk()+"");

        risk3Label.setText(risk3.getDescription()+"");
        risk3Impact.setText(risk3.getImpact()+"");
        risk3Prob.setText(risk3.getProbability()+"");
        risk3Risk.setText(risk3.calculateRisk()+"");
    }
    public void updateBudgetIndicator(){
        budgetIndicator.setProgress(project.getTotalCost()/project.getMoneyBudget());
    }


    public void initialize() {

        loadProject();

        updateAll();

        exitBtn.setOnAction(e -> {
            saveProject();
            Main.stage.close();
        });


        homeBtn.setOnAction(e -> {
            saveProject();
            try {
                anchorPane.getChildren().clear();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/main.fxml"));
                Parent home = loader.load();
                anchorPane.getChildren().add(home);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        memberBtn.setOnAction(e -> {
            saveProject();
            try {
                changePane.getChildren().clear();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/member.fxml"));
                Parent member = loader.load();
                FxmlMemberController controller = loader.getController();

                controller.setProject(this.project);
                controller.setWhenShowed();

                changePane.getChildren().add(member);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        taskBtn.setOnAction(e -> {
            saveProject();
            try {
                changePane.getChildren().clear();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/tasks.fxml"));
                Parent task = loader.load();
                FxmlTasksController controller = loader.getController();

                controller.setProject(this.project);
                controller.updateTaskList();

                changePane.getChildren().add(task);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        searchBtn.setOnAction(e -> {
            saveProject();
            try {
                changePane.getChildren().clear();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/search.fxml"));
                Parent search = loader.load();
                FxmlSearchController controller = loader.getController();

                controller.setProject(this.project);

                changePane.getChildren().add(search);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        ecoBtn.setOnAction(e -> {
            saveProject();
            try{
                changePane.getChildren().clear();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/economics.fxml"));
                Parent eco = loader.load();
                FxmlEcoController controller = loader.getController();

                controller.setProject(this.project);
                controller.showEconomics();

                changePane.getChildren().add(eco);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

    public void loadProject() {
        ReadJSON loadProject = new ReadJSON();
        this.project = loadProject.loadJSON();
    }

    public void saveProject() {
        WriteJSON saveProject = new WriteJSON();
        saveProject.saveJSON(this.project);
    }
}
