package ai.gr64.Mastermind;

import ai.gr64.Mastermind.Game.Color;

public class MmPossibility{
    Color c1, c2, c3, c4;

    public MmPossibility(Color c1, Color c2, Color c3, Color c4) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
    }
    
    //set value nr. x
    public void setValue(int pos, Color color) {

    }

    //get value nr. x
    public Color getValue(int pos) {

    }

    @Override
    public boolean equals(Object o) {
        MmPossibility other = o instanceof MmPossibility ? (MmPossibility)o : null;

        if (other == null)
            return false;
        return !(c1 != other.getValue(0) || 
                 c2 != other.getValue(1) || 
                 c3 != other.getValue(2) || 
                 c4 != other.getValue(3));
    }
}
