package ai.gr64.belief.operations;

import ai.gr64.belief.Possibilities;
import ai.gr64.belief.interfaces.IOpp;

public class Not implements IOpp {

    private IOpp opp1 = null;
    private boolean full = false;

    @Override
    public Possibilities evaluate() {
        return opp1.evaluate().not();
    }

    @Override
    public void addOpp(IOpp opp) {
        if (isFull())
            throw new Error("An operation cannot be added to an already full operation");

        if (opp1 == null) {
            opp1 = opp;
            return;
        }

        opp1.addOpp(opp);
    }

    @Override
    public boolean isFull() {
        if (full)
            return true;

        if (opp1 == null)
            return false;

        if (opp1.isFull()) {
            full = true;
            return true;
        }

        return false;
    }

}
