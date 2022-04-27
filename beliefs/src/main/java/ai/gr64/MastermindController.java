package ai.gr64;

import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.Game.Color;
import javafx.fxml.FXML;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MastermindController {
    Color c1, c2, c3, c4, selectedColour;
    int[][] circleArray = new int[4][10];


    
    //Colour circles
    @FXML
    private Circle circleRed, circleBlack, circleGreen, circleOrange, circleMagenta, circleCyan;

    //Indicator cicles
    //Indicator 1
    @FXML
    private Circle indicator1Row1, indicator1Row2, indicator1Row3, indicator1Row4, indicator1Row5, indicator1Row6, indicator1Row7, indicator1Row8, indicator1Row9, indicator1Row10;
    //Indicator 2
    @FXML
    private Circle indicator2Row1, indicator2Row2, indicator2Row3, indicator2Row4, indicator2Row5, indicator2Row6, indicator2Row7, indicator2Row8, indicator2Row9, indicator2Row10;
    //Indicator 3
    @FXML
    private Circle indicator3Row1, indicator3Row2, indicator3Row3, indicator3Row4, indicator3Row5, indicator3Row6, indicator3Row7, indicator3Row8, indicator3Row9, indicator3Row10;
    //Indicator 4
    @FXML
    private Circle indicator4Row1, indicator4Row2, indicator4Row3, indicator4Row4, indicator4Row5, indicator4Row6, indicator4Row7, indicator4Row8, indicator4Row9, indicator4Row10;
    
    //Guess circles
    //Guess 1
    @FXML
    private Circle guess1Row1, guess1Row2, guess1Row3, guess1Row4, guess1Row5, guess1Row6, guess1Row7, guess1Row8, guess1Row9, guess1Row10;
    //Guess 2
    @FXML
    private Circle guess2Row1, guess2Row2, guess2Row3, guess2Row4, guess2Row5, guess2Row6, guess2Row7, guess2Row8, guess2Row9, guess2Row10;
    //Guess 3
    @FXML
    private Circle guess3Row1, guess3Row2, guess3Row3, guess3Row4, guess3Row5, guess3Row6, guess3Row7, guess3Row8, guess3Row9, guess3Row10;
    //Guess 4
    @FXML
    private Circle guess4Row1, guess4Row2, guess4Row3, guess4Row4, guess4Row5, guess4Row6, guess4Row7, guess4Row8, guess4Row9, guess4Row10;

    private void circleCreation() {
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 10; j++) {
                
            }
            
        }
        
    }

    @FXML
    public void redButton() {
        selectedColour = Color.RED;
    }

    @FXML
    public Circle getGuess1Row1() {
        guess1Row1.setFill(Paint.valueOf(Color.getColor(selectedColour)));
        return guess1Row1;
    }

    @FXML
    public void blackButton() {
        selectedColour = Color.BLACK;
    }

    @FXML
    public void greenButton() {
        selectedColour = Color.GREEN;
    }

    @FXML
    public void orangeButton() {
        selectedColour = Color.ORANGE;
    }

    @FXML
    public void magentaButton() {
        selectedColour = Color.MAGENTA;
    }

    @FXML
    public void cyanButton() {
        selectedColour = Color.CYAN;
    }

    MmPossibility colours = new MmPossibility(c1, c2, c3, c4);

    @FXML
    public MmPossibility guessButton(){
        


        return colours;



    }

    

}
    
