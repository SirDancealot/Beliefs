package ai.gr64;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.Game.Color;
import ai.gr64.Mastermind.Game.Logic;
import ai.gr64.Mastermind.Game.MatchRate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MastermindController implements Initializable {
    Color c1 = Color.UNUSED;
    Color c2 = Color.UNUSED;
    Color c3 = Color.UNUSED;
    Color c4 = Color.UNUSED;
    Color selectedColour = Color.UNUSED;
    Circle[][] guessesArray = new Circle[10][4];
    Circle[][] indicatorArray = new Circle[10][4];

    @FXML
    Pane mastermindPane;

    // Colour circles
    @FXML
    private Circle circleRed;
    @FXML
    private Circle circleBlack;
    @FXML
    private Circle circleGreen;
    @FXML
    private Circle circleOrange;
    @FXML
    private Circle circleMagenta;
    @FXML
    private Circle circleCyan;

    @FXML
    private Button returnToBeliefEngine;
    @FXML
    private Button newGameButton;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        guessCircles();
        indicatorCircles();
        if (!Logic.isGameInProgress())
            Logic.init();
        else
            loadColors();
        // Logic.forceCorrect(new MmPossibility(Color.BLACK, Color.CYAN, Color.GREEN,
        // Color.MAGENTA));

    }

    public void guessCircles() {
        float xCoordinate = 893.0f;
        float yCoordinate = 823.0f;

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 4; x++) {
                final int _y = y;
                final int _x = x;
                guessesArray[y][x] = new Circle(xCoordinate + x * 80, yCoordinate - y * 81, 30.f,
                        Paint.valueOf("DARKGRAY"));
                guessesArray[y][x].setStroke(Paint.valueOf("BLACK"));
                guessesArray[y][x].setStrokeWidth(1);
                mastermindPane.getChildren().add(guessesArray[y][x]);
                guessesArray[y][x].setOnMouseClicked((e) -> {
                    if (_y != Logic.getGuessesMade())
                        return;
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
                    ((Circle) e.getSource()).setFill(Paint.valueOf(Color.getColor(selectedColour)));

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
                        indicatorArray[y][x] = new Circle(xCoordinate, yCoordinate - y * 81, 15.f,
                                Paint.valueOf("SILVER"));
                        break;

                    case 1:
                        indicatorArray[y][x] = new Circle(xCoordinate + 33, yCoordinate - y * 81, 15.f,
                                Paint.valueOf("SILVER"));
                        break;

                    case 2:
                        indicatorArray[y][x] = new Circle(xCoordinate, yCoordinate - y * 81 + 33, 15.f,
                                Paint.valueOf("SILVER"));
                        break;

                    case 3:
                        indicatorArray[y][x] = new Circle(xCoordinate + 33, yCoordinate - y * 81 + 33, 15.f,
                                Paint.valueOf("SILVER"));
                        break;

                    default:
                        break;
                }
                indicatorArray[y][x].setStroke(Paint.valueOf("BLACK"));
                indicatorArray[y][x].setStrokeWidth(1);
                mastermindPane.getChildren().add(indicatorArray[y][x]);

            }
        }

    }

    @FXML
    public void guess(ActionEvent event) {
        if (c1 == Color.UNUSED || c2 == Color.UNUSED || c3 == Color.UNUSED || c4 == Color.UNUSED) {
            Alert a = new Alert(AlertType.INFORMATION);
            // set content text
            a.setContentText("Must select a colour for each position.");

            // show the dialog
            a.show();
            return;
        }
        MmPossibility guess = new MmPossibility(c1, c2, c3, c4);
        MatchRate match = Logic.guess(guess);
        c1 = Color.UNUSED;
        c2 = Color.UNUSED;
        c3 = Color.UNUSED;
        c4 = Color.UNUSED;

        updateIndicators(match);

        if (match.redPins == 4) {
            ButtonType newGame = new ButtonType("New Game", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(AlertType.WARNING,
                    "Congratulations, you guessed the colours!",
                    newGame,
                    cancel);

            alert.setTitle("Game won");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == newGame) {
                Logic.init();
                for (int y = 0; y < 10; y++) {
                    for (int x = 0; x < 4; x++) {
                        guessesArray[y][x].setFill(Paint.valueOf("DARKGRAY"));
                        indicatorArray[y][x].setFill(Paint.valueOf("SILVER"));
                    }
                }

            }

        }

    }

    public void updateIndicators(MatchRate match) {
        int row = Logic.getGuessesMade() - 1;
        int redPins = match.redPins;
        int whitePins = match.whitePins;
        for (int _x = 0; _x < 4; _x++) {
            if (redPins > 0) {
                redPins--;
                indicatorArray[row][_x].setFill(Paint.valueOf("RED"));
            } else if (whitePins > 0) {
                whitePins--;
                indicatorArray[row][_x].setFill(Paint.valueOf("WHITE"));

            } else {
                indicatorArray[row][_x].setFill(Paint.valueOf("SILVER"));
            }
        }
    }

    private void loadColors() {
        MmPossibility[] guesses = Logic.getGuesses();
        MatchRate[] matches = Logic.getMatches();
        for (int y = 0; y < 10; y++) {
            if (guesses[y] == null)
                break;
            int redPins = matches[y].redPins;
            int whitePins = matches[y].whitePins;
            for (int x = 0; x < 4; x++) {
                guessesArray[y][x].setFill(Paint.valueOf(Color.getColor(guesses[y].getValue(x))));
                if (redPins > 0) {
                    redPins--;
                    indicatorArray[y][x].setFill(Paint.valueOf("RED"));
                } else if (whitePins > 0) {
                    whitePins--;
                    indicatorArray[y][x].setFill(Paint.valueOf("WHITE"));

                } else {
                    indicatorArray[y][x].setFill(Paint.valueOf("SILVER"));
                }
            }
        }
    }

    @FXML
    public void returnToBeliefEngine() throws IOException {
        App.setRoot("main");

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

    @FXML
    public void handleNewGameButton() {
        Logic.init();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 4; x++) {
                guessesArray[y][x].setFill(Paint.valueOf("DARKGREY"));
                indicatorArray[y][x].setFill(Paint.valueOf("SILVER"));
            }
        }
        c1 = Color.UNUSED;
        c2 = Color.UNUSED;
        c3 = Color.UNUSED;
        c4 = Color.UNUSED;
        selectedColour = Color.UNUSED;
    }
}
