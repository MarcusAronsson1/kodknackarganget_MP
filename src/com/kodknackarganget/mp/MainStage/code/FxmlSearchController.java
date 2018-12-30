package com.kodknackarganget.mp.MainStage.code;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
public class FxmlSearchController {



    @FXML
    private Label searchIdLabel;
    @FXML
    private Label searchMailLabel;
    @FXML
    private Label searchSalaryLabel;
    @FXML
    private Label searchHoursLabel;
    @FXML
    private Label searchIdLabel1;
    @FXML
    private Label searchMailLabel1;
    @FXML
    private Label searchSalaryLabel1;
    @FXML
    private Label searchHoursLabel1;
    @FXML
    private ImageView searchImage;


    public void onEnter(ActionEvent actionEvent) throws IOException {

        TextField id = (TextField) actionEvent.getSource();
        Image image = new Image("com/kodknackarganget/mp/MainStage/Img/augusticon.png");
        searchImage.setImage(image);
        searchImage.setOpacity(1);
        searchIdLabel.setText("ID: "+id.getText());//member.getId();
        searchMailLabel.setText("Mail: august@gmail.com");//member.getEmail();
        searchSalaryLabel.setText("Salary: 199 SEK/H");//member.getSalary();
        searchHoursLabel.setText("Total Hours: 34");//member.getHours();

        searchIdLabel1.setText("Implement search function");//member.getTask();
        searchMailLabel1.setText("Learn JavaFx");
        searchSalaryLabel1.setText("Write new methods in member class");
        searchHoursLabel1.setText("Plan after work");

    }



}
