package com.kodknackarganget.mp.MainStage.code;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FxmlMemberController {

    private Project project;

    @FXML
    private Pane parentPane;

    public void setProject(Project project) {
        this.project = project;
    }

    public void initialize() {
    }

    public void setWhenShowed() {

        for(int i = 0; i < project.getProjectMembers().size(); i++) {
            Pane pane = (Pane)parentPane.getChildren().get(i);

            Label label = (Label)pane.getChildren().get(0);
            label.setText("Name: "+project.getProjectMembers().get(i).getName());

            label = (Label)pane.getChildren().get(1);
            label.setText("Mail: "+project.getProjectMembers().get(i).getEmail());

            label = (Label)pane.getChildren().get(2);
            label.setText("ID: "+project.getProjectMembers().get(i).getId());

            label = (Label)pane.getChildren().get(3);
            label.setText("Salary: "+project.getProjectMembers().get(i).getCostPerHour());
        }

    }


}