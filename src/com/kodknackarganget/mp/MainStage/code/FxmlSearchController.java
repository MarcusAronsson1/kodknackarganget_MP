package com.kodknackarganget.mp.MainStage.code;

import com.kodknackarganget.mp.Member;
import com.kodknackarganget.mp.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FxmlSearchController {

    @FXML
    private Label idLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label hoursLabel;
    @FXML
    private VBox taskVBox;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField search;

    private Project project;

    private final String VALID_INT_REGEX = "\\d+";

    private final int MAX_AMOUNT_TASKS = 6;

    public void setProject(Project project) {
        this.project = project;
    }


    public void onEnter(ActionEvent actionEvent) throws IOException {
        int idInput = 0;
        if (search.getText().matches(VALID_INT_REGEX)) {
            idInput = Integer.parseInt(search.getText());
            try {
                Member member = project.getMember(idInput);
                clearFields();
                nameLabel.setText("Name: " + member.getName());
                idLabel.setText("ID: " + member.getId());
                mailLabel.setText("E-mail: " + member.getEmail());
                salaryLabel.setText("Salary: " + member.getCostPerHour());
                hoursLabel.setText("Hours worked: " + member.getHoursWorked());

                ArrayList<String> taskNames = member.getTaskNames();

                for (int i = 0; i < taskNames.size() && i < MAX_AMOUNT_TASKS; i++) {
                    Label label = (Label) taskVBox.getChildren().get(i);
                    label.setText(taskNames.get(i));
                }

            } catch (Exception exc) {
                clearFields();
                nameLabel.setText(exc.getMessage());
            }
        } else {
            clearFields();
            nameLabel.setText("Invalid input");
        }

    }

    public void clearFields() {
        nameLabel.setText("");
        idLabel.setText("");
        mailLabel.setText("");
        salaryLabel.setText("");
        hoursLabel.setText("");
        for (int i = 0; i < MAX_AMOUNT_TASKS; i++) {
            Label label = (Label) taskVBox.getChildren().get(i);
            label.setText("");
        }
    }


}
