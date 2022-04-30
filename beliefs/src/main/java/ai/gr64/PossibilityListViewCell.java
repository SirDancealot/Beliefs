package ai.gr64;

import java.io.IOException;

import ai.gr64.Mastermind.MmPossibility;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PossibilityListViewCell extends ListCell<MmPossibility>{
    @FXML
    private Text column1;
    @FXML
    private Text column2;
    @FXML
    private Text column3;
    @FXML
    private Text column4;
    @FXML
    private GridPane banana;
    
    private FXMLLoader mlLoader;

    @Override
    protected void updateItem(MmPossibility possibility, boolean empty) {
        super.updateItem(possibility, empty);

        if (empty || possibility == null) {
            setText(null);
            setGraphic(null);
            
        } else {
            if (mlLoader == null) {
                mlLoader = new FXMLLoader(getClass().getResource("possibilityListViewCell.fxml"));
                mlLoader.setController(this);

                try {
                    mlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            column1.setText(possibility.getValue(0).toString());
            column2.setText(possibility.getValue(1).toString());
            column3.setText(possibility.getValue(2).toString());
            column4.setText(possibility.getValue(3).toString());
    
            setText(null);
            setGraphic(banana);
        }



        
    }
    
}
