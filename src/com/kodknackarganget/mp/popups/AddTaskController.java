package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.kodknackarganget.mp.Main.stage;

public class AddTaskController {

    @FXML
    private TextField descriptionField;
    @FXML
    private TextField startWeekField;
    @FXML
    private TextField endWeekField;
    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;

    public void initialize(){

        saveBtn.setOnAction(e -> {

            if(startWeekField.getText().matches("\\d+") && endWeekField.getText().matches("\\d+")) {
                //Project.addTask(descriptionField.getText(), Integer.parseInt(startWeekField.getText()), Integer.parseInt(endWeekField.getText()));
                stage.close();
            }
        });

        cancelBtn.setOnAction(e -> stage.close());

    }

}
