package ai.gr64.Mastermind.Game;
import java.util.Scanner;

import ai.gr64.Mastermind.MmPossibility;

public class Logic {
    private static MmPossibility correct = null;
    private static MmPossibility[] guesses = new MmPossibility[10];
    
    //init metode til at starte spillet forfra. reset nyt spil.(ikke sikker på hvad metoden skal have i argument)
    public static void init(String[] args) {
        System.out.println("game has started!");

        guesses = new MmPossibility[10];

        // Generate what the answer will be
    }

    public static matchRate guess(MmPossibility guess) {
        // compare guess and correct, return how many colors are correct position, or just the right color (red and white pegs)
    }

    //guess metode til at gætte, den returnerer hvor godt gættet var.(mm possibility) giv dette til spillet. Denne gør så man kan komme med et gæt.
    public static void makeGuess(String[] args) {
        System.out.println("have a guess!");
        System.out.println("guesses go from left to right");
        System.out.println("Type r for red");
        System.out.println("Type b for black");
        System.out.println("Type g for green");
        System.out.println("Type y for yellow");
        System.out.println("Type m for magenta");
        System.out.println("Type c for cyan");

        Scanner scan = new Scanner(System.in);
        int colourGuessed = scan.nextInt();

        MmPossibility guess = new MmPossibility(c1, c2, c3, c4);

        for (int j = 0; j < 4; j++){
            colourGuessed = scan.nextLine().split(" ");
            
            if(colourGuessed == 0){
                System.out.println("from the left, spot number " + j + "has been set to red");
                guess.setValue(j, color);
            } else if(colourGuessed == 1){
                System.out.println("from the left, spot number " + j + "has been set to black");
            } else if(colourGuessed == 2){
                System.out.println("from the left, spot number " + j + "has been set to green");
            } else if(colourGuessed == 3){
                System.out.println("from the left, spot number " + j + "has been set to yellow");
            } else if(colourGuessed == 4){
                System.out.println("from the left, spot number " + j + "has been set to magenta");
            } else if(colourGuessed == 5){
                System.out.println("from the left, spot number " + j + "has been set to cyan");
            } else {
                System.out.prinln("Error. invalid input. Number has to be between 0-5!");
            }

            switch (colourGuessed) {
                case 'r':
                    guess.setValue(j, Color.RED);
                    break;
            
                default:
                    break;
            }
        }

        /*if(row_x[] == actualResult[]){
            System.out.println("you win");
            return win
        } else {
            System.out.println("you lose!");
            return loss
        }*/

    }
    //gør alt static(betyder man ikke skal oprette instanser af en klasse.)

}
