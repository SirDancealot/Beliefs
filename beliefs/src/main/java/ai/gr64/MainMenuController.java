package ai.gr64;

import java.io.IOException;

import ai.gr64.belief.interfaces.IOpp;
import ai.gr64.belief.operations.And;
import ai.gr64.belief.operations.Not;
import ai.gr64.belief.operations.Or;
import ai.gr64.belief.operations.Parenthesis;
import ai.gr64.belief.operations.Unit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private Button notButton;
    @FXML
    private Button andButton;
    @FXML
    private Button orButton;
    @FXML
    private Button unitButton;
    @FXML
    private Button parenthesisButton;
    @FXML
    private TextField baseTextField;
    @FXML
    private TextField possibilityTextField;
    @FXML
    private TextField qubeTextField;
    @FXML
    private TextField iTextField;

    private static IOpp k = new Parenthesis();
    private static IOpp i, p, q;

    @FXML
    public void handleNot(ActionEvent event) {
        k.addOpp(new Not());
    }

    @FXML
    public void handleAnd(ActionEvent event) {
        k.addOpp(new And());
    }

    @FXML
    public void handleOr(ActionEvent event) {
        k.addOpp(new Or());
    }

    @FXML
    public void handleParenthesis(ActionEvent event) {
        k.addOpp(new Parenthesis());
    }

    public void unitAdded(Unit unit) {
        k.addOpp(unit);
    }

    @FXML
    public void handleUnit(ActionEvent event) {
        Stage stage = (Stage) (((Button) event.getSource()).getScene().getWindow());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inputPopUp.fxml"));
            Parent root = loader.load();

            InputPopUpController controller = loader.getController();
            controller.setOwner(this);

            Scene secondScene = new Scene(root, 600, 400);
            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");
            newWindow.setScene(secondScene);

            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);

            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(stage);

            // Set position of second window, related to primary window.
            newWindow.setX(stage.getX() + 200);
            newWindow.setY(stage.getY() + 100);

            newWindow.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToMastermind() throws IOException {
        App.setRoot("mastermindScreen");
    }

    @FXML
    public void handleRevision(ActionEvent event) {

    }

    public static void gui() {
        i = new Parenthesis();

    }

}
