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

    private final String VALID_INT_REGEX = "\\d+";

    private String errorTextColor = "-fx-text-fill: red";
    private String regTextColor = "-fx-text-fill: #D3E7F1";

    public void initialize(){

        descriptionField.setOnKeyTyped(e -> descriptionField.setStyle(regTextColor));
        startWeekField.setOnKeyTyped(e -> startWeekField.setStyle(regTextColor));
        endWeekField.setOnKeyTyped(e -> endWeekField.setStyle(regTextColor));


        saveBtn.setOnAction(e -> {

            boolean allInputsAreValid = true;

            String startWeek = startWeekField.getText();
            int intStartWeek = 0;
            String endWeek = endWeekField.getText();
            int intEndWeek = 0;
            String description = descriptionField.getText();

            if (description.isEmpty()) {
                descriptionField.setStyle(errorTextColor);
                descriptionField.setText("Field can't be empty");
                allInputsAreValid = false;
            }

            try {
                intStartWeek = convertWeekToInt(startWeek);
            } catch (Exception exc) {
                startWeekField.setStyle(errorTextColor);
                startWeekField.setText(exc.getMessage());
                allInputsAreValid = false;
            }

            try {
                intEndWeek = convertWeekToInt(endWeek);
            } catch (Exception exc) {
                endWeekField.setStyle(errorTextColor);
                endWeekField.setText(exc.getMessage());
                allInputsAreValid = false;
            }

            if(allInputsAreValid) {
                Project.addTask(description, intStartWeek, intEndWeek);
                stage.close();
            }
        });


        cancelBtn.setOnAction(e -> stage.close());

    }

    public int convertWeekToInt(String week) throws Exception {
        if (week.matches(VALID_INT_REGEX)) {
            int intWeek = Integer.parseInt(week);
            if (intWeek >= 1) {
                return intWeek;
            } else {
                throw new Exception("Week must be greater than 0.");
            }
        } else {
            throw new Exception("Week must be digits only.");
        }
    }

}
