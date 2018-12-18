package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import static com.kodknackarganget.mp.Main.stage;

public class AddRiskController {

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

    public void initialize() {

        addBtn.setOnAction(e -> {
            int impact = (int) impactSlider.getValue();
            int probability = (int) probSlider.getValue();
            String description = descriptionField.getText();

            if(!description.isEmpty()) {
                //Project.addRisk(description, probability, impact);
                stage.close();
            }else{
                descriptionField.setText("Field can't be empty.");
                descriptionField.setStyle("-fx-text-fill: red");
            }
        });

        cancelBtn.setOnAction(e -> {
            stage.close();
        });
    }

}
