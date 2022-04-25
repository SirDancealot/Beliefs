package ai.gr64.belief;

import ai.gr64.belief.interfaces.IOpp;
import ai.gr64.belief.operations.And;
import ai.gr64.belief.operations.Contraction;
import ai.gr64.belief.operations.ElementsInSet;
import ai.gr64.belief.operations.Expansion;
import ai.gr64.belief.operations.Intersection;
import ai.gr64.belief.operations.Not;
import ai.gr64.belief.operations.NotElement;
import ai.gr64.belief.operations.NotSubsetEqual;
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
    
    public void handleNot(ActionEvent event) {
        i.addOpp(new Not());
    }

    public void handleAnd(ActionEvent event) {
        i.addOpp(new And());
    }

    public void handleElementsInSet(ActionEvent event) {
        i.addOpp(new ElementsInSet());
    }

    public void handleNotElement(ActionEvent event) {
        i.addOpp(new NotElement());
    }

    public void handleIntersection(ActionEvent event) {
        i.addOpp(new Intersection());
    }

    public void handleUnion(ActionEvent event) {
        i.addOpp(new Union());
    }

    public void handleSubSetEqual(ActionEvent event) {
        i.addOpp(new SubsetEqual());
    }

    public void handleNotSubSet(ActionEvent event) {
        i.addOpp(new NotSubsetEqual());
    }

    public void handlePreferenceOrdering(ActionEvent event) {
        i.addOpp(new PreferenceOrdering());
    }

    public void handleContraction(ActionEvent event) {
        i.addOpp(new Contraction());
    }

    public void handleRevision(ActionEvent event) {
        i.addOpp(new Revision());
    }

    public void handleExpansion(ActionEvent event) {
        i.addOpp(new Expansion());
    }
    
    public void handleParenthesis(ActionEvent event) {
        i.addOpp(new Parenthesis());
    }
    
    


    
    public static void gui() {
        i = new Parenthesis();
        
        
        
        i.addOpp(new And());
        
        
        
    }
    
}
