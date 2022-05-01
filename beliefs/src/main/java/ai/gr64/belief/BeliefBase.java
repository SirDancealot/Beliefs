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

    public BeliefBase clone() {
        BeliefBase newBase = new BeliefBase();
        newBase.setPossibilities((new MmPossibilities()).outerJoin(base));
        return newBase;
    }

    private void setPossibilities(Possibilities possibilities) {
        this.base = possibilities;
    }
}
