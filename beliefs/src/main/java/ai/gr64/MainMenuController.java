package ai.gr64;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ai.gr64.Mastermind.MmPossibilities;
import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.AI.AIUtils;
import ai.gr64.Mastermind.Game.Color;
import ai.gr64.Mastermind.Game.MatchRate;
import ai.gr64.belief.BeliefBase;
import ai.gr64.belief.interfaces.IOpp;
import ai.gr64.belief.operations.And;
import ai.gr64.belief.operations.Not;
import ai.gr64.belief.operations.Or;
import ai.gr64.belief.operations.Parenthesis;
import ai.gr64.belief.operations.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

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
    private Button resetBase;
    @FXML
    private Button resetBaseText;
    @FXML
    private Button revisionButton;
    @FXML
    private Button buttonMastermind;
    @FXML
    private TextField baseTextField;
    @FXML
    private ListView<MmPossibility> possibilitiesList;

    private ObservableList<MmPossibility> possibilitiesOl;

    private static BeliefBase base = new BeliefBase();

    public static boolean inputPopUpOpen = false;

    private static IOpp k = new Parenthesis();
    private static String baseText = "⬚";

    public MainMenuController() {
        possibilitiesOl = FXCollections.observableArrayList();
        possibilitiesOl.addAll(base.getPossibilities().getSet());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        baseTextField.setText(baseText);
        possibilitiesList.setItems(possibilitiesOl);
        possibilitiesList.setCellFactory(possibilitiesListView -> new PossibilityListViewCell());
    }

    @FXML
    public void handleNot(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        if (checkFull())
            return;
        k.addOpp(new Not());
        updateBaseText("¬⬚");
        
        
    }

    @FXML
    public void handleAnd(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        if (checkFull())
            return;
        k.addOpp(new And());
        updateBaseText("⬚∧☐");
    }

    @FXML
    public void handleOr(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        if (checkFull())
            return;
        k.addOpp(new Or());
        updateBaseText("⬚∨☐");
    }

    @FXML
    public void handleParenthesis(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        if (checkFull())
            return;
        k.addOpp(new Parenthesis());
        updateBaseText("(⬚)");
    }

    public void unitAdded(Unit unit) {
        if (inputPopUpOpen) {
            return;
        }
        if (checkFull())
            return;
        k.addOpp(unit);
        updateBaseText("U");
        String text = baseTextField.getText();
        baseTextField.setText(text.replaceFirst("☐", "⬚"));
    }

    private boolean checkFull() {
        if (k.isFull()) {

            return true;
        }
        return false;
    }

    private void updateBaseText(String replacement) {
        if (inputPopUpOpen) {
            return;
        }
        String org = baseTextField.getText();
        baseTextField.setText(org.replace("⬚", replacement));

    }

    @FXML
    public void handleUnit(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        Stage stage = (Stage) (((Button) event.getSource()).getScene().getWindow());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inputPopUp.fxml"));
            Parent root = loader.load();

            InputPopUpController controller = loader.getController();
            controller.setOwner(this);

            Scene secondScene = new Scene(root, 600, 400);
            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Color combination selection");
            newWindow.setScene(secondScene);

            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);

            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(stage);

            // Set position of second window, related to primary window.
            newWindow.setX(stage.getX() + 200);
            newWindow.setY(stage.getY() + 100);

            newWindow.show();

            inputPopUpOpen = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToMastermind() throws IOException {
        if (inputPopUpOpen) {
            return;
        }
        baseText = baseTextField.getText();
        ((Stage)notButton.getScene().getWindow()).setTitle("Mastermind");
        App.setRoot("mastermindScreen");
    }

    @FXML
    public void handleRevision(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        if (!k.isFull())
            return;
        base.Revise(k.evaluate());
        possibilitiesOl.setAll(base.getPossibilities().getSet());
        k = new Parenthesis();
        baseTextField.setText("⬚");
        
    }

    @FXML
    public void handleResetBase(ActionEvent event) {
        if (inputPopUpOpen) {
            return;
        }
        base = new BeliefBase();
        possibilitiesOl.setAll(base.getPossibilities().getSet());
    }

    @FXML
    public void handleResetBaseText() {
        if (inputPopUpOpen) {
            return;
        }
        baseText = "⬚";
        k = new Parenthesis();
        baseTextField.setText(baseText);
    }

        
}
