package ai.gr64.belief.operations;

import ai.gr64.belief.Possibilities;
import ai.gr64.belief.interfaces.IOpp;

public class Intersection implements IOpp {

    private IOpp opp1 = null;
    private IOpp opp2 = null;
    private boolean full = false;

    @Override
    public Possibilities evaluate() {
        // TODO Auto-generated method stub
        return null;
    }
     
    @Override
    public void addOpp(IOpp opp) {
        if (full)
            throw new Error("An operation cannot be added to an already full operation");

        if (opp1 == null) {
            opp1 = opp;
            return;
        }

        if (!opp1.isFull()) {
            opp1.addOpp(opp);
            return;
        }

        if (opp2 == null) {
            opp2 = opp;
            return;
        }

        if (!opp2.isFull()) {
            opp2.addOpp(opp);
        }
    }

    @Override
    public boolean isFull() {
        if (full)
            return true;

        if (opp1 == null || opp2 == null)
            return false;

        if (!opp1.isFull())
            return false;

        if (!opp2.isFull())
            return false;
        
        full = true;
        return true;
    }
 
}
