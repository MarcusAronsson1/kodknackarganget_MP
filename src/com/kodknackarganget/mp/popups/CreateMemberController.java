package com.kodknackarganget.mp.popups;

import com.kodknackarganget.mp.Project;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.kodknackarganget.mp.Main.stage;

public class CreateMemberController {

    private Project project;

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

    private String errorTextColor = "-fx-text-fill: red";
    private String regTextColor = "-fx-text-fill: #D3E7F1";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void initialize(){

        nameField.setOnKeyTyped(e -> nameField.setStyle(regTextColor));
        idField.setOnKeyTyped(e -> idField.setStyle(regTextColor));
        mailField.setOnKeyTyped(e -> mailField.setStyle(regTextColor));
        costField.setOnKeyTyped(e -> costField.setStyle(regTextColor));

        saveBtn.setOnAction(e -> {

            boolean allInputsAreValid = true;

            String name = nameField.getText();
            if(name.isEmpty()){
                nameField.setStyle(errorTextColor);
                nameField.setText("Field can't be empty");
                allInputsAreValid = false;
            }

            int id = 0;
            try{
                id = convertStrToInt(idField.getText());
                if(idIsTaken(id)){
                    idField.setStyle(errorTextColor);
                    allInputsAreValid = false;
                }
            }catch (Exception exception){
                idField.setText(exception.getMessage());
                idField.setStyle(errorTextColor);
                allInputsAreValid = false;
            }

            String mail = mailField.getText();
            if(!mailIsValid(mail)){
                allInputsAreValid = false;
            }

            int cost = 0;
            try{
                cost = convertStrToInt(costField.getText());
            }catch (Exception exception){
                costField.setText(exception.getMessage());
                costField.setStyle(errorTextColor);
                allInputsAreValid = false;
            }

            if(allInputsAreValid){
                project.addMember(name, id, mail, cost);
                stage.close();
            }


        });

        cancelBtn.setOnAction(e -> stage.close());


    }

    private boolean mailIsValid(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        if(matcher.find()){
            return true;
        }else{
            mailField.setStyle(errorTextColor);
            mailField.setText("Mail is not valid.");
            return false;
        }
    }

    private int convertStrToInt(String str) throws Exception{
        if(str.matches("\\d+")){
            return Integer.parseInt(str);
        }else{
            throw new Exception("Must be digits only.");
        }
    }


    private boolean idIsTaken(int inputId){

        ArrayList<Integer> takenIDs = project.takenIds();
        if(takenIDs.contains(inputId)){
            idField.setStyle(errorTextColor);
            return true;
        }

        return false;
    }

}
