package ai.gr64.Mastermind.AI;

import java.util.ArrayList;
import java.util.List;


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
}