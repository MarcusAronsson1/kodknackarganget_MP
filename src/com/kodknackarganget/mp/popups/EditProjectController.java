package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static com.kodknackarganget.mp.Main.stage;

public class EditProjectController extends Controller {

    private String errorTextColor = "-fx-text-fill: red";
    private String regTextColor = "-fx-text-fill: #D3E7F1";

    private final String VALID_INT_REGEX = "\\d+";
    private final String VALID_DOUBLE_REGEX = "\\d+\\.\\d+";

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


    public void initialize() {

        nameField.setOnKeyTyped(e -> nameField.setStyle(regTextColor));
        startWeekField.setOnKeyTyped(e -> startWeekField.setStyle(regTextColor));
        endWeekField.setOnKeyTyped(e -> endWeekField.setStyle(regTextColor));
        hoursBudgetField.setOnKeyTyped(e -> hoursBudgetField.setStyle(regTextColor));
        moneyBudgetField.setOnKeyTyped(e -> moneyBudgetField.setStyle(regTextColor));

        saveBtn.setOnAction(e -> {
            String projectName = nameField.getText();
            String startWeek = startWeekField.getText();
            String endWeek = endWeekField.getText();
            String hourBudget = hoursBudgetField.getText();
            String moneyBudget = moneyBudgetField.getText();

            boolean allInputsAreValid = true;

            //sets project name unless its empty
            if (projectName.isEmpty()) {
                nameField.setStyle(errorTextColor);
                nameField.setText("Field can't be empty");
                allInputsAreValid = false;
            } else {
                getProject().setName(projectName);
            }

            //Trying to convert startWeek to int and checks if its a valid week
            try {
                int intStartWeek = convertWeekToInt(startWeek);
                getProject().setStartWeek(intStartWeek);
            } catch (Exception exc) {
                startWeekField.setStyle(errorTextColor);
                startWeekField.setText(exc.getMessage());
                allInputsAreValid = false;
            }
            //same for endWeek
            try {
                int intEndWeek = convertWeekToInt(endWeek);
                getProject().setEndWeek(intEndWeek);
            } catch (Exception exc) {
                endWeekField.setStyle(errorTextColor);
                endWeekField.setText(exc.getMessage());
                allInputsAreValid = false;
            }

            try {
                double doubleHourBudget = convertStrToDouble(hourBudget);
                getProject().setHourBudget(doubleHourBudget);
            } catch (Exception exc) {
                hoursBudgetField.setStyle(errorTextColor);
                hoursBudgetField.setText(exc.getMessage());
                allInputsAreValid = false;
            }

            try {
                double doubleMoneyBudget = convertStrToDouble(moneyBudget);
                getProject().setMoneyBudget(doubleMoneyBudget);
            } catch (Exception exc) {
                moneyBudgetField.setStyle(errorTextColor);
                moneyBudgetField.setText(exc.getMessage());
                allInputsAreValid = false;
            }

            if (allInputsAreValid) {
                stage.close();
            }
        });

        cancelBtn.setOnAction(e -> {
            stage.close();
        });

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

    public double convertStrToDouble(String str) throws Exception {
        if (str.matches(VALID_INT_REGEX) || str.matches(VALID_DOUBLE_REGEX)) {
            return Double.parseDouble(str);
        } else {
            throw new Exception("Invalid input.");
        }
    }

    public void showCurrentProjectInfo(){
        nameField.setText(getProject().getName());
        startWeekField.setText(getProject().getStartWeek() + "");
        endWeekField.setText(getProject().getEndWeek() + "");
        hoursBudgetField.setText(getProject().getHourBudget() + "");
        moneyBudgetField.setText(getProject().getMoneyBudget() + "");
    }

}
