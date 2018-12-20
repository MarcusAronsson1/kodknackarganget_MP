package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.io.IOException;


public class FxmlTasksController {

    @FXML
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;
    @FXML
    private CheckBox checkbox7, checkbox8, checkbox9, checkbox10, checkbox11, checkbox12;
    @FXML
    private Button addBtn1, addBtn2, addBtn3, addBtn4, addBtn5, addBtn6;
    @FXML
    private Button addBtn7, addBtn8, addBtn9, addBtn10, addBtn11, addBtn12;
    //@FXML
    //private Pane taskpane1;
    @FXML
    private Pane addPane;
    @FXML
    private TextField addMemberTask;
    @FXML
    private Button doneBtn;



    public void checkboxLeft(CheckBox box){
        if (box.isSelected()) {
            box.setOpacity(0.5);
            Node test = box.getParent().getChildrenUnmodifiable().get(2);
            test.setOpacity(0.5);
            //getTask(test.getName()).isCompleted(true);
        }else{
            box.setOpacity(1);
            Node test = box.getParent().getChildrenUnmodifiable().get(2);
            test.setOpacity(1);
        }
    }

    public void checkboxRight(CheckBox box){
        if (box.isSelected()) {
            box.setOpacity(0.5);
            Node test = box.getParent().getChildrenUnmodifiable().get(0);
            test.setOpacity(0.5);
            //getTask(taskpane1.getName()).isCompleted(true);
        }else{
            box.setOpacity(1);
            Node test = box.getParent().getChildrenUnmodifiable().get(0);
            test.setOpacity(1);
        }
    }

    public void initialize() {

        doneBtn.setOnAction(e -> {
            addPane.setOpacity(0);
        });

        checkbox1.setOnAction(e -> {
            checkboxRight(checkbox1);
        });

        checkbox2.setOnAction(e -> {
            checkboxLeft(checkbox2);
        });

        checkbox3.setOnAction(e -> {
            checkboxRight(checkbox3);
        });

        checkbox4.setOnAction(e -> {
            checkboxLeft(checkbox4);
        });

        checkbox5.setOnAction(e -> {
            checkboxRight(checkbox5);
        });

        checkbox6.setOnAction(e -> {
            checkboxLeft(checkbox6);
        });

        checkbox7.setOnAction(e -> {
            checkboxRight(checkbox7);
        });

        checkbox8.setOnAction(e -> {
            checkboxLeft(checkbox8);
        });

        checkbox9.setOnAction(e -> {
            checkboxRight(checkbox9);
        });

        checkbox10.setOnAction(e -> {
            checkboxLeft(checkbox10);
        });

        checkbox11.setOnAction(e -> {
            checkboxRight(checkbox11);
        });

        checkbox12.setOnAction(e -> {
            checkboxLeft(checkbox12);
        });

        addBtn1.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn2.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn3.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn4.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn5.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn6.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn7.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn8.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn9.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn10.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn11.setOnAction(e -> {

            addPane.setOpacity(1);
        });

        addBtn12.setOnAction(e -> {

            addPane.setOpacity(1);
        });

    }


    public void onEnter(ActionEvent actionEvent) throws IOException {

        doneBtn.setOpacity(1);
       // String ID = addMemberTask.getText();
        //task.addMember(ID);
        addMemberTask.clear();
    }
}
