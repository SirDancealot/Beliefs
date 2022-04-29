package ai.gr64;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class InputPopUpController implements Initializable{

    @FXML
    private Text color1;
    @FXML
    private Text color2;
    @FXML
    private Text color3;
    @FXML
    private Text color4;
    @FXML
    private Text redText;
    @FXML
    private Text blackText;
    @FXML
    private Text greenText;
    @FXML
    private Text orangText;
    @FXML
    private Text magentaText;
    @FXML
    private Text cyanText;

    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;

    @FXML
    Pane inputPopUpPane;
    
    boolean[][] colorsArray = new boolean[4][6];

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colorsArray = new boolean[4][6];
        initializeCheckBoxes();
        
        
    }
    


    @FXML
    public void okButton(ActionEvent event) {
        boolean legal = true;
        for (int x = 0; x < 4; x++) {
            boolean rowLegal = false;
            for (int y = 0; y < 6; y++) {
                if (colorsArray[x][y]) {
                    rowLegal = true;
                    break;
                }
            }
            if (!rowLegal) {
                legal = false;
                break;
            }
        }
        if (!legal) {
            Alert a = new Alert(AlertType.INFORMATION);
            // set content text
            a.setContentText("Must select a colour for each position.");

            // show the dialog
            a.show();
            return;
        }

        
    }

    @FXML
    public void cancelButton(ActionEvent event) {
        
    }

    
    public void initializeCheckBoxes() {
        for (int x = 0; x < 4; x++) {
            final int _x = x;
            for (int y = 0; y < 6; y++) {
                final int _y = y;
                CheckBox checkBox = new CheckBox();
                checkBox.setLayoutX(93+x*133);
                checkBox.setLayoutY(87+y*40);

                inputPopUpPane.getChildren().add(checkBox);

                checkBox.setOnAction((event) -> {
                    colorsArray[_x][_y] = !colorsArray[_x][_y];
                    System.out.println(colorsArray[0][0]);

                });

            }
        }
        
    }





    
    
}
