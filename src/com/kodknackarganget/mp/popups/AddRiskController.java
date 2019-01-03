package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Controller;
import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import static com.kodknackarganget.mp.Main.stage;

public class AddRiskController extends Controller {

    @FXML
    private TextField descriptionField;
    @FXML
    private Button addBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Slider impactSlider;
    @FXML
    private Slider probSlider;

    private String errorTextColor = "-fx-text-fill: red";
    private String regTextColor = "-fx-text-fill: #D3E7F1";

    public void initialize() {

        descriptionField.setOnKeyTyped(e -> descriptionField.setStyle(regTextColor));

        addBtn.setOnAction(e -> {
            int impact = (int) impactSlider.getValue();
            int probability = (int) probSlider.getValue();
            String description = descriptionField.getText();

            if(!description.isEmpty()) {
                getProject().addRisk(description, probability, impact);
                stage.close();
            }else{
                descriptionField.setText("Field can't be empty.");
                descriptionField.setStyle(errorTextColor);
            }
        });

        cancelBtn.setOnAction(e -> {
            stage.close();
        });
    }

}
