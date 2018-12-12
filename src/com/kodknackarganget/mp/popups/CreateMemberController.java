package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

import static com.kodknackarganget.mp.Main.stage;

public class CreateMemberController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField costField;
    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;

    private String redFont = "-fx-text-fill: red";

    public void initialize(){

        saveBtn.setOnAction(e -> {

            boolean allInputsAreValid = true;

            String name = nameField.getText();
            if(name.isEmpty()){
                nameField.setStyle(redFont);
                nameField.setText("Field can't be empty");
                allInputsAreValid = false;
            }

            int id = 0;
            try{
                id = convertStrToInt(idField.getText());
                if(idIsTaken(id)){
                    idField.setStyle(redFont);
                    allInputsAreValid = false;
                }
            }catch (Exception exception){
                idField.setText(exception.getMessage());
                idField.setStyle(redFont);
                allInputsAreValid = false;
            }

            String mail = mailField.getText();
            if(!mailIsValid(mail)){
                mailField.setText("Mail is not valid.");
                mailField.setStyle(redFont);
                allInputsAreValid = false;
            }

            int cost = 0;
            try{
                cost = convertStrToInt(costField.getText());
            }catch (Exception exception){
                costField.setText(exception.getMessage());
                costField.setStyle(redFont);
                allInputsAreValid = false;
            }

            if(allInputsAreValid){
                Project.addMember(name, id, mail, cost);
                stage.close();
            }


        });

        cancelBtn.setOnAction(e -> stage.close());


    }

    private boolean mailIsValid(String mailInput){
        if(mailInput.contains("@")){
            return true;
        }
        mailField.setStyle(redFont);
        return false;
    }

    private int convertStrToInt(String str) throws Exception{
        if(str.matches("\\d+")){
            return Integer.parseInt(str);
        }else{
            throw new Exception("Must be digits only.");
        }
    }


    private boolean idIsTaken(int inputId){

        ArrayList<Integer> takenIDs = Project.takenIds();
        if(takenIDs.contains(inputId)){
            idField.setStyle(redFont);
            return true;
        }

        return false;
    }
}
