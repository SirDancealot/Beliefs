package ai.gr64;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.IntFunction;

import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.Game.Color;
import ai.gr64.Mastermind.Game.Logic;
import ai.gr64.Mastermind.Game.MatchRate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MastermindController implements Initializable {
    Color c1, c2, c3, c4, selectedColour;
    Circle[][] circleArray = new Circle[10][4];

    @FXML
    Pane mastermindPane;
    


    
    //Colour circles
    @FXML
    private Circle circleRed, circleBlack, circleGreen, circleOrange, circleMagenta, circleCyan;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        guessCircles();
        indicatorCircles();
        
    }
    

    public void guessCircles() {
        float xCoordinate = 893.0f;
        float yCoordinate = 823.0f;

        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 4; x++) {
                final int _y = y;
                final int _x = x;
                circleArray[y][x] = new Circle(xCoordinate + x*80, yCoordinate - y*81, 30.f);
                mastermindPane.getChildren().add(circleArray[y][x]);
                circleArray[y][x].setOnMouseClicked((e) ->{
                    if (_y!=Logic.getGuessesMade()) return;
                    switch (_x) {
                        case 0:
                            c1 = selectedColour;
                            break;
                        
                        case 1:
                            c2 = selectedColour;
                            break;
    
                        case 2:
                            c3 = selectedColour;
                            break;
    
                        case 3:
                            c4 = selectedColour;
                            break;
                        
                        default:
                            break;
                    }
                    ((Circle)e.getSource()).setFill(Paint.valueOf(Color.getColor(selectedColour)));
                    
                });
            
                
            }
        }
        
    }

    

    public void indicatorCircles() {
        float xCoordinate = 1208.0f;
        float yCoordinate = 808.0f;

        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 4; x++) {
            
                
                switch (x) {
                    case 0:
                        circleArray[y][x] = new Circle(xCoordinate, yCoordinate - y*81, 15.f);
                        break;
                    
                    case 1:
                        circleArray[y][x] = new Circle(xCoordinate + 33, yCoordinate - y*81, 15.f);
                        break;

                    case 2:
                        circleArray[y][x] = new Circle(xCoordinate, yCoordinate - y*81 + 33, 15.f);
                        break;

                    case 3:
                        circleArray[y][x] = new Circle(xCoordinate + 33, yCoordinate - y*81 + 33, 15.f);
                        break;
                    
                    default:
                        break;
                }
                mastermindPane.getChildren().add(circleArray[y][x]);
            
                
            }
        }
        
    }

    @FXML
    public void guess(ActionEvent event) {
        MmPossibility guess = new MmPossibility(c1, c2, c3, c4);
        MatchRate match = Logic.guess(guess);
        
        
    }

    @FXML
    public void playGame(ActionEvent event) {
        Logic.init();
        
        
    }

    @FXML
    public void redButton() {
        selectedColour = Color.RED;
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
   

}
    
