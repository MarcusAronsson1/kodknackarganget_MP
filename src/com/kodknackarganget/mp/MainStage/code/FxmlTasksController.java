package com.kodknackarganget.mp.MainStage.code;

import com.kodknackarganget.mp.Project;
import com.kodknackarganget.mp.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class FxmlTasksController {

    @FXML
    private Pane addPane;
    @FXML
    private TextField addMemberTask;
    @FXML
    private Button doneBtn;
    @FXML
    private Pane changePaneTask;

    private Project project;

    private ArrayList<Task> tasks;

    private String taskDescription;

    private final int MAX_AMOUNT_TASKS = 12;
    private final String VALID_INT_REGEX = "\\d+";

    public void setProject(Project project){
        this.project = project;
        this.tasks = project.getTasks();
    }

    public void updateTaskList(){
        for(int i = 0; i < MAX_AMOUNT_TASKS && i < tasks.size(); i++) {
            Pane taskPane = (Pane) changePaneTask.getChildren().get(i);
            Label taskLabel = (Label) taskPane.getChildren().get(0);
            taskLabel.setText(tasks.get(i).getDescription());
            if(tasks.get(i).isCompleted()){
                taskPane.setOpacity(0.5);
                CheckBox checkBox = (CheckBox)taskPane.getChildren().get(1);
                checkBox.setSelected(true);
            }else{
                taskPane.setOpacity(1);
                CheckBox checkBox = (CheckBox)taskPane.getChildren().get(1);
                checkBox.setSelected(false);
            }
        }
    }

    public void completeTask(ActionEvent actionEvent) {

        CheckBox box = (CheckBox) actionEvent.getSource();
        Label taskLabel = (Label)box.getParent().getChildrenUnmodifiable().get(0);
        String taskDescription = taskLabel.getText();
        try {
            if(box.isSelected()) {
                project.getTask(taskDescription).setCompleted(true);
                box.getParent().setOpacity(0.5);
            }else{
                project.getTask(taskDescription).setCompleted(false);
                box.getParent().setOpacity(1);
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    public void addMemberToTask(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Label taskLabel = (Label)button.getParent().getChildrenUnmodifiable().get(0);
        taskDescription = taskLabel.getText();
        addPane.setOpacity(1);
    }

    public void initialize() {

        doneBtn.setOnAction(e -> {
            if(addMemberTask.getText().matches(VALID_INT_REGEX)) {
                String strId = addMemberTask.getText();
                int id = Integer.parseInt(strId);
                try {
                    project.addMemberToTask(id, taskDescription);
                    addPane.setOpacity(0);
                    addMemberTask.setText("");
                } catch (Exception exc) {
                    addMemberTask.setText(exc.getMessage());
                }
            }else{
                addMemberTask.setText("Invalid input.");
            }
        });
    }



}
