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
    public void setValue(int pos, Color color) {//lav dette som switchcase istedet
        if (pos == 0){
            c1 = color;
        }
        if (pos == 1){
            c2 = color;
        }
        if (pos == 2){
            c3 = color;
        }
        if (pos == 3){
            c4 = color;
        }
    }

    //get value nr. x
    public Color getValue(int pos){//lav dette til switchcase
        if(pos == 0){
            return c1;
        }
        if(pos == 1){
            return c2;
        }
        if(pos == 2){
            return c3;
        }
        if(pos == 3){
            return c4;
        }
        throw new Error("Pos out of bound. Must be in range of 0-3");
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
