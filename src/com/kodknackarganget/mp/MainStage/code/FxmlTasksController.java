package com.kodknackarganget.mp.MainStage.code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.io.IOException;


public class FxmlTasksController {

    @FXML
    private Pane addPane;
    @FXML
    private TextField addMemberTask;
    @FXML
    private Button doneBtn;
    @FXML
    private ImageView testaug;


    public void checkboxRight(ActionEvent actionEvent) {

        CheckBox box = (CheckBox) actionEvent.getSource();
        box.setId(box.getId());
        if (box.isSelected()) {
            box.setOpacity(0.5);
            Node test = box.getParent().getChildrenUnmodifiable().get(0);
            test.setOpacity(0.5);
            //getTask(task.getName()).isCompleted(true);
        } else {
            box.setOpacity(1);
            Node test = box.getParent().getChildrenUnmodifiable().get(0);
            test.setOpacity(1);
        }
    }

    public void checkboxLeft(ActionEvent actionEvent) {

        CheckBox box = (CheckBox) actionEvent.getSource();
        box.setId(box.getId());
        if (box.isSelected()) {
            box.setOpacity(0.5);
            Node test = box.getParent().getChildrenUnmodifiable().get(2);
            test.setOpacity(0.5);
            //getTask(task.getName()).isCompleted(true);
        } else {
            box.setOpacity(1);
            Node test = box.getParent().getChildrenUnmodifiable().get(2);
            test.setOpacity(1);
        }
    }

    public void addMemberToTask(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        //button.getParent().getChildrenUnmodifiable().get();
        addPane.setOpacity(1);

    }


    public void initialize() {

        doneBtn.setOnAction(e -> {
            addPane.setOpacity(0);
        });
    }


    public void onEnter(ActionEvent actionEvent) throws IOException {

        if (addMemberTask.getText().equals("1337")) {
            //testaug.setOpacity(1);
            doneBtn.setOpacity(1);
            Node imageView = testaug.getParent().getChildrenUnmodifiable().get(3);
            imageView.setOpacity(1);
            // String ID = addMemberTask.getText();
            //task.addMember(ID);
            addMemberTask.clear();
        } else {
            doneBtn.setOpacity(1);
            // String ID = addMemberTask.getText();
            //task.addMember(ID);
            addMemberTask.clear();
            Node imageView = testaug.getParent().getChildrenUnmodifiable().get(3);
            imageView.setOpacity(1);
        }
    }


}
