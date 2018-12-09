package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

import static com.kodknackarganget.mp.Main.stage;

public class addRiskController {

    @FXML
    private TextField descriptionInput;
    @FXML
    private Label header;
    @FXML
    private Button addBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label xBtn;
    @FXML
    private Slider impactSlider;
    @FXML
    private Slider probSlider;
    @FXML
    private ToggleGroup projectOrTask;
    @FXML
    private RadioButton projectRadio;
    @FXML
    private RadioButton taskRadio;
    @FXML
    private ComboBox<String> taskDropDown;

    public void initialize() {

        addTasksToDropDown();

        addBtn.setOnAction(e -> {
            RadioButton selectedRadio = (RadioButton) projectOrTask.getSelectedToggle();
            int impact = (int) impactSlider.getValue();
            int probability = (int) probSlider.getValue();
            String description = descriptionInput.getText();

            if (selectedRadio == projectRadio) {
                Project.addRisk(description, probability, impact);
            }else if (selectedRadio == taskRadio){
                String selectedTask = taskDropDown.getSelectionModel().getSelectedItem().toString();
                Project.addRiskToTask(selectedTask, description, probability, impact);
            }
        });

        cancelBtn.setOnAction(e -> {
            stage.close();
        });
    }

    public void addTasksToDropDown(){
        ArrayList<String> taskDescriptions = Project.getUncompletedTasks();

        for(String currentTask: taskDescriptions){
            taskDropDown.getItems().add(currentTask);
        }
    }

}
