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
        //colourSegment = new int[4];
        // Generate what the answer will be

    }

    public static matchRate guess(MmPossibility guess) {
        // compare guess and correct, return how many colors are correct position, or just the right color (red and white pegs)
        /*for(i = 0; i < 10; i++){
            if(MmPossibility[i] == colourSegmant[]){
                return guess;
            }
        }*/
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
            

            switch (colourGuessed) {
                case 'r':
                    guess.setValue(j, Color.RED);
                    System.out.println("from the left, spot number " + j + "has been set to red");
                    break;
                case 'b':
                    guess.setValue(j, Color.BLACK);
                    System.out.println("from the left, spot number " + j + "has been set to black");
                    break;
                case 'g':
                    guess.setValue(j, Color.GREEN);
                    System.out.println("from the left, spot number " + j + "has been set to green");
                    break;
                case 'y':
                    guess.setValue(j, Color.YELLOW);
                    System.out.println("from the left, spot number " + j + "has been set to yellow");
                    break;
                case 'm':
                    guess.setValue(j, Color.MAGENTA);
                    System.out.println("from the left, spot number " + j + "has been set to magenta");
                    break;
                case 'c':
                    guess.setValue(j, Color.CYAN);
                    System.out.println("from the left, spot number " + j + "has been set to cyan");
                    break;
                default:
                    System.out.println("Error.");
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
