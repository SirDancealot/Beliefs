package ai.gr64.Mastermind.AI;

import java.util.ArrayList;
import java.util.List;

import ai.gr64.Mastermind.MmPossibilities;
import ai.gr64.Mastermind.MmPossibility;
import ai.gr64.Mastermind.Game.Color;
import ai.gr64.Mastermind.Game.MatchRate;

public class AIUtils {
    public static List<Match[]> generatePermutations(List<Match> remaining) {
        List<Match[]> perms = generatePermutations(new ArrayList<>(), remaining, new ArrayList<>());
        List<Match[]> uniquePerms = new ArrayList<>();

        for (Match[] match : perms) {
            boolean unique = true;

            for (Match[] checked : uniquePerms) {
                boolean different = false;
                for (int i = 0; i < 4; i++) {
                    if (match[i] != checked[i]) {
                        different = true;
                        break;
                    }
                }
                if (!different) {
                    unique = false;
                    break;
                }
            }

            if (unique)
                uniquePerms.add(match);
        }
        return uniquePerms;
    }

    private static List<Match[]> generatePermutations(List<Match> current, List<Match> remaining, List<Match[]> acc) {
        if (remaining.isEmpty()) {
            Match[] combination = new Match[4];
            acc.add(current.toArray(combination));
            return acc;
        }

        for (Match match : remaining) {
            List<Match> nextCurrent = new ArrayList<>();
            nextCurrent.addAll(current);
            nextCurrent.add(match);

            List<Match> nextRemaining = new ArrayList<>();
            nextRemaining.addAll(remaining);
            nextRemaining.remove(match);

            generatePermutations(nextCurrent, nextRemaining, acc);
        }

        return acc;
    }

    public static MmPossibilities LegalFromMove(MmPossibility guess, MatchRate match) {
        int redPins = match.redPins;
        int whitePins = match.whitePins;

        boolean anyWhite = whitePins > 0;

        List<Match> pool = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (redPins > 0) {
                redPins--;
                pool.add(Match.RED);
            } else if (whitePins > 0) {
                whitePins--;
                pool.add(Match.WHITE);
            } else {
                pool.add(Match.NOTHING);
            }
        }

        List<Match[]> permutations = generatePermutations(pool);

        if (!anyWhite) {
            MmPossibilities combinedPossibilities = new MmPossibilities();

            for (Match[] permutation : permutations) {
                List<Color>[] colors = new List[4];
                for (int i = 0; i < 4; i++) {
                    colors[i] = new ArrayList<Color>();

                    switch (permutation[i]) {
                        case RED:
                            colors[i].add(guess.getValue(i));
                            break;
                        case WHITE:
                            throw new Error("White should never appear here");
                        case NOTHING:
                            colors[i].add(Color.RED);
                            colors[i].add(Color.GREEN);
                            colors[i].add(Color.BLACK);
                            colors[i].add(Color.MAGENTA);
                            colors[i].add(Color.CYAN);
                            colors[i].add(Color.ORANGE);
                            colors[i].remove(guess.getValue(i));
                            break;
                    }
                }

                Color[] c1 = new Color[colors[0].size()];
                Color[] c2 = new Color[colors[1].size()];
                Color[] c3 = new Color[colors[2].size()];
                Color[] c4 = new Color[colors[3].size()];
                colors[0].toArray(c1);
                colors[1].toArray(c2);
                colors[2].toArray(c3);
                colors[3].toArray(c4);

                combinedPossibilities = (MmPossibilities) combinedPossibilities
                        .outerJoin(new MmPossibilities(c1, c2, c3, c4));
            }

            return combinedPossibilities;
        }

        List<Integer> remaining = new ArrayList<>();
        remaining.add(0);
        remaining.add(1);
        remaining.add(2);
        remaining.add(3);
        List<Integer[]> intPerms = generateIntPermutations(new ArrayList<>(), remaining, new ArrayList<>());

        MmPossibilities combinedPossibilities = new MmPossibilities();

        for (Match[] matchPerm : permutations) {

            for (Integer[] intPerm : intPerms) {
                List<Color>[] colors = new List[4];

                boolean legal = true;
                for (int i = 0; i < 4; i++) {
                    colors[i] = new ArrayList<>();

                    if (i == intPerm[i]) {
                        if (matchPerm[i] == Match.RED) {
                            colors[i].add(guess.getValue(i));
                        } else if (matchPerm[i] == Match.NOTHING) {
                            colors[i].add(Color.RED);
                            colors[i].add(Color.GREEN);
                            colors[i].add(Color.BLACK);
                            colors[i].add(Color.MAGENTA);
                            colors[i].add(Color.CYAN);
                            colors[i].add(Color.ORANGE);
                            colors[i].remove(guess.getValue(i));
                        } else {
                            legal = false;
                            break;
                        }
                    } else {
                        if (matchPerm[intPerm[i]] == Match.RED) {
                            legal = false;
                            break;
                        } else if (matchPerm[intPerm[i]] == Match.NOTHING) {
                            colors[i].add(Color.RED);
                            colors[i].add(Color.GREEN);
                            colors[i].add(Color.BLACK);
                            colors[i].add(Color.MAGENTA);
                            colors[i].add(Color.CYAN);
                            colors[i].add(Color.ORANGE);
                            colors[i].remove(guess.getValue(intPerm[i]));
                        } else {
                            colors[i].add(guess.getValue(intPerm[i]));
                        }
                    }
                }

                if (legal) {
                    Color[] c1 = new Color[colors[0].size()];
                    Color[] c2 = new Color[colors[1].size()];
                    Color[] c3 = new Color[colors[2].size()];
                    Color[] c4 = new Color[colors[3].size()];
                    colors[0].toArray(c1);
                    colors[1].toArray(c2);
                    colors[2].toArray(c3);
                    colors[3].toArray(c4);

                    combinedPossibilities = (MmPossibilities) combinedPossibilities
                            .outerJoin(new MmPossibilities(c1, c2, c3, c4));
                }
            }
        }

        return combinedPossibilities;
    }

    private static List<Integer[]> generateIntPermutations(List<Integer> current, List<Integer> remaining,
            List<Integer[]> acc) {
        if (remaining.isEmpty()) {
            Integer[] combination = new Integer[4];
            acc.add(current.toArray(combination));
            return acc;
        }

        for (int match : remaining) {
            List<Integer> nextCurrent = new ArrayList<>();
            nextCurrent.addAll(current);
            nextCurrent.add(match);

            List<Integer> nextRemaining = new ArrayList<>();
            nextRemaining.addAll(remaining);
            nextRemaining.remove(nextRemaining.indexOf(match));

            generateIntPermutations(nextCurrent, nextRemaining, acc);
        }

        return acc;
    }
}