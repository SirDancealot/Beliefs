package ai.gr64.belief;

import ai.gr64.Mastermind.MmPossibilities;

public class BeliefBase {
    private Possibilities base;

    public BeliefBase() {
        base = MmPossibilities.AllPossibilities;
    }

    public MmPossibilities getPossibilities() {
        return (MmPossibilities)base;
    }

    public void Revise(Possibilities possibilities) {
        base = base.innerJoin(possibilities);
    }
}
