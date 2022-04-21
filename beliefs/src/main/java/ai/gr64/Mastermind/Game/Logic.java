package ai.gr64.Mastermind.Game;
import java.util.Scanner;

public class Logic {
    
    //init metode til at starte spillet forfra. reset nyt spil.(ikke sikker på hvad metoden skal have i argument)
    public static void init(String[] args) {
        System.out.println("game has started!");


        //array til at holde styr på alle gæt for hver row
        int[] row_1;
        int[] row_2;
        int[] row_3;
        int[] row_4;
        int[] row_5;
        int[] row_6;
        int[] row_7;
        int[] row_8;
        int[] row_9;
        int[] row_10;
        
        row_1 = new int[4];//array der skal indeholde de forskellige gæt
        row_2 = new int[4];//array der skal indeholde de forskellige gæt
        row_3 = new int[4];//array der skal indeholde de forskellige gæt
        row_4 = new int[4];//array der skal indeholde de forskellige gæt
        row_5 = new int[4];//array der skal indeholde de forskellige gæt
        row_6 = new int[4];//array der skal indeholde de forskellige gæt
        row_7 = new int[4];//array der skal indeholde de forskellige gæt
        row_8 = new int[4];//array der skal indeholde de forskellige gæt
        row_9 = new int[4];//array der skal indeholde de forskellige gæt
        row_10 = new int[4];//array der skal indeholde de forskellige gæt

        /*pseudo(ish) for restart
        if(new game button pressed){
            System.out.println("game restarted");
            for(i=1; i<4; i++){
                row_1[i] = empty;
                row_2[i] = empty;
                row_3[i] = empty;
                row_4[i] = empty;
                row_5[i] = empty;
                row_6[i] = empty;
                row_7[i] = empty;
                row_8[i] = empty;
                row_9[i] = empty;
                row_10[i] = empty;
            }*/
    }

    //guess metode til at gætte, den returnerer hvor godt gættet var.(mm possibility) giv dette til spillet. Denne gør så man kan komme med et gæt.
    public static void guess(String[] args) {
        System.out.println("have a guess!");
        System.out.println("guesses go from left to right");
        System.out.println("Type 0 for red");
        System.out.println("Type 1 for black");
        System.out.println("Type 2 for green");
        System.out.println("Type 3 for yellow");
        System.out.println("Type 4 for magenta");
        System.out.println("Type 5 for cyan");

        Scanner scan = new Scanner(System.in);
        int colourGuessed = scan.nextInt();

        for (int j = 0; j < 4; j++){
            colourGuessed = scan.nextInt();
            
            row_1[j] = colourGuessed;
            if(colourGuessed == 0){
                System.out.println("from the left, spot number " + j + "has been set to red");
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
