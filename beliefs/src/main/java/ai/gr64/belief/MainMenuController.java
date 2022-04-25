package ai.gr64.belief;

import ai.gr64.belief.interfaces.IOpp;
import ai.gr64.belief.operations.And;
import ai.gr64.belief.operations.Parenthesis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainMenuController {

    @FXML
    private Button notButton, andButton, elementsInSetButton, notElementButton, intersectionButton, unionButton, subsetEqualButton;
    @FXML
    private Button notSubsetButton, preferenceOrderingButton, contractionButton, revisionButton, expansionButton, parantesisButton;
    @FXML
    private TextField baseTextField, possibilityTextField, qubeTextField, iTextField;

    private static IOpp i ,k, p, q;
    
    
    public static void gui() {
        i = new Parenthesis();
        
        public void handleAnd(ActionEvent event);
        
        i.addOpp(new And());
        
        
        
    }
    
}
