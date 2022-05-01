package ai.gr64.Mastermind.Game;

import ai.gr64.belief.BeliefBase;
import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.Game.Logic;
import ai.gr64.Mastermind.MmPossibilities;

public class AINodes {
    private static BeliefBase base;

    public static void guesser(){

        base = new BeliefBase();

        MmPossibility firstGuess = new MmPossibility(Color.BLACK, Color.BLACK, Color.RED, Color.RED);  
        MatchRate result = new MatchRate();

        result = Logic.guess(firstGuess);

        //Update the base set, only when you want to make the guess
        base.Revise(combined);

        //See what the base set would be if it was revised by combine, without updateing the base set
        MmPossibilities pos = ((MmPossibilities)base.getPossibilities().innerJoin(combined));

        //Gets the number of different possibilities if the base set was revised with combined, without updating the base set
        int numPossibilities = ((MmPossibilities)base.getPossibilities().innerJoin(combined)).getSet().size();
    }
}
