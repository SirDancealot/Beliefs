package ai.gr64;

import ai.gr64.belief.BeliefBase;
import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.Game.Color;
import ai.gr64.Mastermind.Game.Logic;
import ai.gr64.Mastermind.Game.MatchRate;
import ai.gr64.Mastermind.MmPossibilities;

public class AINodes {
    static Color[] pos1 = new Color[]{Color.RED, Color.BLACK, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};
    static Color[] pos2 = new Color[]{Color.RED, Color.BLACK, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};
    static Color[] pos3 = new Color[]{Color.RED, Color.BLACK, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};
    static Color[] pos4 = new Color[]{Color.RED, Color.BLACK, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.CYAN};



    public static void guesser(){

        BeliefBase base = new BeliefBase();
        Color c1 = Color.BLACK;
        Color c2 = Color.BLACK;
        Color c3 = Color.RED;
        Color c4 = Color.RED;


        MmPossibility firstGuess = new MmPossibility(c1, c2, c3, c4);  

        MatchRate result = Logic.guess(firstGuess);
        MmPossibilities fromGuess = new MmPossibilities();

        for (int i = 0; i < result.redPins; i++) {
            fromGuess = (MmPossibilities)fromGuess.outerJoin(new MmPossibilities(new Color[]{Color.UNUSED}, new Color[]{Color.UNUSED}, new Color[]{Color.UNUSED}, new Color[]{Color.UNUSED}));
        }

        base.Revise(fromGuess);



        pos1 = colors(c1);
        pos2 = colors(c2);
        pos3 = colors(c3);
        pos4 = colors(c4);

        //Update the base set, only when you want to make the guess
        base.Revise(combined);

        //See what the base set would be if it was revised by combine, without updateing the base set
        MmPossibilities pos = ((MmPossibilities)base.getPossibilities().innerJoin(combined));

        //Gets the number of different possibilities if the base set was revised with combined, without updating the base set
        int numPossibilities = ((MmPossibilities)base.getPossibilities().innerJoin(combined)).getSet().size();

        //Create one set of possibilities
        MmPossibilities pos1 = new MmPossibilities(new Color[]{ Color.RED, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE }, 
                                                    new Color[]{ Color.RED, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE }, 
                                                    new Color[]{ Color.BLACK }, 
                                                    new Color[]{ Color.RED });

        //Create another set of possibilities
        MmPossibilities pos2 = new MmPossibilities(new Color[]{ Color.BLACK }, new Color[]{ Color.RED, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE }, new Color[]{ Color.BLACK }, new Color[]{ Color.RED });

        //Add them together
        MmPossibilities added = pos1.outerJoin(pos2);
    }

    private static Color[] colors(Color color) {
        switch (color) {
            case RED:
                return "DARKRED";
            case BLACK:
                return "BLACK";
            case GREEN:
                return "LAWNGREEN";
            case ORANGE:
                return "ORANGERED";
            case MAGENTA:
                return "DEEPPINK";
            case CYAN:
                return "CYAN";
        
            default:
                throw new Error("Value must be in range 0-5");
        }
        
        return null;
    }

    
}
