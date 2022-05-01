package ai.gr64;

import java.net.URL;
import java.util.ResourceBundle;

import ai.gr64.Mastermind.Game.Color;
import ai.gr64.belief.operations.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InputPopUpController implements Initializable {

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

    private MainMenuController owner;
    boolean[][] colorsArray = new boolean[4][6];

    public void setOwner(MainMenuController owner) {
        this.owner = owner;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colorsArray = new boolean[4][6];
        initializeCheckBoxes();

    }

    @FXML
    public void okButton(ActionEvent event) {
        int[] row = new int[4];
        for (int x = 0; x < 4; x++) {

            for (int y = 0; y < 6; y++) {
                if (colorsArray[x][y]) {
                    row[x]++;
                }
            }

        }
        if (row[0] * row[1] * row[2] * row[3] == 0) {
            Alert a = new Alert(AlertType.INFORMATION);
            // set content text
            a.setContentText("Must select a colour for each position.");

            // show the dialog
            a.show();
            return;
        }

        Color[][] colors = new Color[4][];
        for (int i = 0; i < 4; i++) {
            colors[i] = new Color[row[i]];
            int colorsCollumn = 0;
            for (int j = 0; j < 6; j++) {
                if (colorsArray[i][j]) {
                    colors[i][colorsCollumn] = Color.fromValue(j);
                    colorsCollumn++;
                }
            }
        }

        Unit unit = new Unit(colors[0], colors[1], colors[2], colors[3]);
        owner.unitAdded(unit);
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void initializeCheckBoxes() {
        for (int x = 0; x < 4; x++) {
            final int _x = x;
            for (int y = 0; y < 6; y++) {
                final int _y = y;
                CheckBox checkBox = new CheckBox();
                checkBox.setLayoutX(93 + x * 133);
                checkBox.setLayoutY(87 + y * 40);

                inputPopUpPane.getChildren().add(checkBox);

                checkBox.setOnAction((event) -> {
                    colorsArray[_x][_y] = !colorsArray[_x][_y];
                });

            }
        }

    }

}
