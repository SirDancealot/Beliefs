package ai.gr64.Mastermind;

import java.util.ArrayList;
import java.util.List;

import ai.gr64.Mastermind.Game.Color;
import ai.gr64.belief.Possibilities;

public class MmPossibilities implements Possibilities {
    public static final MmPossibilities AllPossibilities = allPossibilities();

    private List<MmPossibility> Possibilities = new ArrayList<>();

    
    public void AddPossibility(MmPossibility pos){
        Possibilities.add(pos);
    }

    @Override
    public Possibilities overlap(Possibilities other) {
        // TODO Auto-generated method stub
        return null;
    }

    private static MmPossibilities allPossibilities() {
        MmPossibilities pos = new MmPossibilities();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        pos.AddPossibility(new MmPossibility(Color.fromValue(i), Color.fromValue(j), Color.fromValue(k), Color.fromValue(l)));
                    }
                }
            }
        }

        return pos;
    }
    
}
