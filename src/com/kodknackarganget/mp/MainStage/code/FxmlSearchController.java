package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

        searchImage.setOpacity(1);
        searchIdLabel.setText("ID: 1337");
        searchMailLabel.setText("Mail: august@gmail.com");
        searchSalaryLabel.setText("Salary: 199 SEK/H");
        searchHoursLabel.setText("Total Hours: 34");

        searchIdLabel1.setText("ID: 1337");
        searchMailLabel1.setText("Mail: august@gmail.com");
        searchSalaryLabel1.setText("Salary: 199 SEK/H");
        searchHoursLabel1.setText("Total Hours: 34");

    }
}
