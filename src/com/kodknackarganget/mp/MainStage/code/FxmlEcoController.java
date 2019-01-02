package com.kodknackarganget.mp.MainStage.code;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.text.DecimalFormat;


public class FxmlEcoController {

    private Project project;

    @FXML
    private Pane svPane;
    @FXML
    private Pane cvPane;
    @FXML
    private Pane evPane;

    private static DecimalFormat df2 = new DecimalFormat("0.00");

    public void setProject(Project project) {
        this.project = project;
    }

    public void showEconomics() {
        try {

            Label label = (Label) evPane.getChildren().get(1);
            label.setText(df2.format(project.calculateEarnedValue()) + " SEK");

            Label label1 = (Label) cvPane.getChildren().get(1);
            label1.setText(df2.format(project.calculateCostVariance()) + " SEK");

            Label label2 = (Label) svPane.getChildren().get(1);
            label2.setText(df2.format(project.calculateScheduleVariance()) + " SEK");


        } catch (Exception e) {
            Label label = (Label) evPane.getChildren().get(1);
            label.setText(e.getMessage());

            Label label1 = (Label) cvPane.getChildren().get(1);
            label1.setText(e.getMessage());

            Label label2 = (Label) svPane.getChildren().get(1);
            label2.setText(e.getMessage());
        }


    }

}