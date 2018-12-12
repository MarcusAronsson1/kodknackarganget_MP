package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.kodknackarganget.mp.Main.stage;

public class EditProjectController {

    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField nameField;
    @FXML
    private TextField startWeekField;
    @FXML
    private TextField endWeekField;
    @FXML
    private TextField hoursBudgetField;
    @FXML
    private TextField moneyBudgetField;



    public void initialize(){


        String currentName = Project.getName();
        int currentStartWeek = Project.getStartWeek();
        int currentEndWeek = Project.getEndWeek();
        double currentHourBudget = Project.getHourBudget();
        double currentMoneyBudget = Project.getMoneyBudget();

        nameField.setText(currentName);
        startWeekField.setText(currentStartWeek + "");
        endWeekField.setText(currentEndWeek + "");
        hoursBudgetField.setText(currentHourBudget + "");
        moneyBudgetField.setText(currentMoneyBudget + "");

        saveBtn.setOnAction(e -> {
            String projectName = nameField.getText();
            String startWeek = startWeekField.getText();
            String endWeek = endWeekField.getText();
            String hourBudget = hoursBudgetField.getText();
            String moneyBudget = moneyBudgetField.getText();

            Project.setName(projectName);
            if(startWeek.matches("\\d+") && endWeek.matches("\\d+")){
                Project.setSchedule(Integer.parseInt(startWeek), Integer.parseInt(endWeek));
            }
            if(hourBudget.matches("\\d+\\.\\d+")){
                Project.setHourBudget(Double.parseDouble(hourBudget));
            }
            if(moneyBudget.matches("\\d+\\.\\d+")){
                Project.setMoneyBudget(Double.parseDouble(moneyBudget));
            }

            stage.close();
        });

        cancelBtn.setOnAction(e -> {
            stage.close();
        });

    }

}
