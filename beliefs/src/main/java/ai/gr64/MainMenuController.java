package ai.gr64;

import java.io.IOException;

import ai.gr64.belief.interfaces.IOpp;
import ai.gr64.belief.operations.And;
import ai.gr64.belief.operations.Contraction;
import ai.gr64.belief.operations.ElementsInSet;
import ai.gr64.belief.operations.Expansion;
import ai.gr64.belief.operations.Intersection;
import ai.gr64.belief.operations.Not;
import ai.gr64.belief.operations.NotElement;
import ai.gr64.belief.operations.NotSubsetEqual;
import ai.gr64.belief.operations.Or;
import ai.gr64.belief.operations.Parenthesis;
import ai.gr64.belief.operations.PreferenceOrdering;
import ai.gr64.belief.operations.Revision;
import ai.gr64.belief.operations.SubsetEqual;
import ai.gr64.belief.operations.Union;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController {

    @FXML
    private Button notButton, andButton, elementsInSetButton, notElementButton, intersectionButton, unionButton, subsetEqualButton;
    @FXML
    private Button notSubsetButton, preferenceOrderingButton, contractionButton, revisionButton, expansionButton, parenthesisButton;
    @FXML
    private TextField baseTextField, possibilityTextField, qubeTextField, iTextField;

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
    public void handleElementsInSet(ActionEvent event) {
        i.addOpp(new ElementsInSet());
    }

    @FXML
    public void handleNotElement(ActionEvent event) {
        i.addOpp(new NotElement());
    }

    @FXML
    public void handleIntersection(ActionEvent event) {
        i.addOpp(new Intersection());
    }

    @FXML
    public void handleUnion(ActionEvent event) {
        i.addOpp(new Union());
    }

    @FXML
    public void handleSubSetEqual(ActionEvent event) {
        i.addOpp(new SubsetEqual());
    }

    @FXML
    public void handleNotSubSet(ActionEvent event) {
        i.addOpp(new NotSubsetEqual());
    }

    @FXML
    public void handlePreferenceOrdering(ActionEvent event) {
        i.addOpp(new PreferenceOrdering());
    }

    @FXML
    public void handleContraction(ActionEvent event) {
        i.addOpp(new Contraction());
    }

    @FXML
    public void handleRevision(ActionEvent event) {
        i.addOpp(new Revision());
    }

    @FXML
    public void handleExpansion(ActionEvent event) {
        i.addOpp(new Expansion());
    }

    @FXML
    public void handleParenthesis(ActionEvent event) {
        i.addOpp(new Parenthesis());
    }
    
    @FXML
    private void switchToMastermind() throws IOException {
        App.setRoot("mastermindScreen");
    }


    
    public static void gui() {
        i = new Parenthesis();
        
        
        
        
        
    }
    
}
