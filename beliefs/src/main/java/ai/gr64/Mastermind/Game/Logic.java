package ai.gr64.Mastermind.Game;

import java.util.Random;
import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.AI.AIUtils;
import ai.gr64.belief.BeliefBase;

public class Logic {
    private static boolean gameInProgress = false;
    private static MmPossibility correct = null;
    private static MmPossibility[] guesses = new MmPossibility[10];
    private static MatchRate[] guessMatch = new MatchRate[10];
    private static int guessesMade = 0;
    private static BeliefBase base = new BeliefBase();

    // init method to start the game from the beginning.
    public static void init() {
        gameInProgress = true;
        guessesMade = 0;
        base = new BeliefBase();
        System.out.println("game has started!");

        guesses = new MmPossibility[10];
        guessMatch = new MatchRate[10];

        // Generate what the answer will be
        correct = new MmPossibility(Color.UNUSED, Color.UNUSED, Color.UNUSED, Color.UNUSED);

        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int color = r.nextInt(6);
            correct.setValue(i, Color.fromValue(color));
        }
    }

    // this method returns how good a guess the ism and also if the guess is correct
    // compare guess and correct, return how many colors are correct position, or
    // just the right color (red and white pegs)
    public static MatchRate guess(MmPossibility guess) {
        guesses[guessesMade] = guess;
        guessesMade++;
        int redpins = 0;
        int whitepins = 0;

        if (guess == correct) {
            redpins = 4;
            gameInProgress = false;
        } else if (guess != correct) {

            boolean[] usedCorrect = new boolean[] { false, false, false, false };
            boolean[] usedGuess = new boolean[] { false, false, false, false };

            for (int i = 0; i < 4; i++) {
                if (guess.getValue(i) == correct.getValue(i)) {
                    redpins++;
                    usedCorrect[i] = true;
                    usedGuess[i] = true;
                    continue;
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guess.getValue(j) == correct.getValue(i) && !usedCorrect[i] && !usedGuess[j]) {
                        usedCorrect[i] = true;
                        usedGuess[j] = true;
                        whitepins++;

                    }
                }
            }
        }

        MatchRate r = new MatchRate();
        r.whitePins = whitepins;
        r.redPins = redpins;

        guessMatch[guessesMade - 1] = r;
        base.Revise(AIUtils.LegalFromMove(guess, r));
        return r;

    }

    // testing method
    public static void forceCorrect(MmPossibility _correct) {
        correct = _correct;

    }

    public static int getGuessesMade() {
        return guessesMade;
    }

    public static boolean isGameInProgress() {
        return gameInProgress;
    }

    public static MmPossibility[] getGuesses() {
        return guesses;
    }

    public static MatchRate[] getMatches() {
        return guessMatch;
    }

    public static BeliefBase getBeliefBase() {
        return base;
    }
}
