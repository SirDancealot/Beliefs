package ai.gr64.belief.operations;

import ai.gr64.Mastermind.MmPossibilities;
import ai.gr64.Mastermind.Game.Color;
import ai.gr64.belief.Possibilities;
import ai.gr64.belief.interfaces.IOpp;

public class Unit implements IOpp {
    private MmPossibilities value;

    public Unit(Color[] c1, Color[] c2, Color[] c3, Color[] c4) {
        value = new MmPossibilities(c1, c2, c3, c4);
    }

    @Override
    public Possibilities evaluate() {
        return value;
    }

    @Override
    public void addOpp(IOpp opp) {
        throw new Error("A sub-operation cannot be added to a unit");
    }

    @Override
    public boolean isFull() {
        return true;
    }
}
