package ai.gr64;

import java.io.IOException;

import ai.gr64.belief.interfaces.IOpp;
import ai.gr64.belief.operations.And;
import ai.gr64.belief.operations.Not;
import ai.gr64.belief.operations.Or;
import ai.gr64.belief.operations.Parenthesis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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


    private static IOpp i ,k, p, q;
    
    @FXML
    public void handleNot(ActionEvent event) {
        i.addOpp(new Not());
    }

    @FXML
    public void handleAnd(ActionEvent event) {
        i.addOpp(new And());
    }

    @FXML
    public void handleOr(ActionEvent event) {
        i.addOpp(new Or());
    }

    @FXML
    public void handleParenthesis(ActionEvent event) {
        i.addOpp(new Parenthesis());
    }
    
    @FXML
    public void handleUnit(ActionEvent event) {
        
    }

    @FXML
    private void switchToMastermind() throws IOException {
        App.setRoot("mastermindScreen");
    }


    
    public static void gui() {
        i = new Parenthesis();
        
        
        
        
        
    }
    
}
