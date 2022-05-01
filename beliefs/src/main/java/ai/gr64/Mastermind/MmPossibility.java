package ai.gr64.Mastermind;

import ai.gr64.Mastermind.Game.Color;

public class MmPossibility implements Comparable {
    Color c1, c2, c3, c4;

    public MmPossibility(Color c1, Color c2, Color c3, Color c4) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
    }

    // set position and color
    public void setValue(int pos, Color color) {// lav dette som switchcase istedet
        switch (pos) {
            case 0:
                c1 = color;
                break;
            case 1:
                c2 = color;
                break;
            case 2:
                c3 = color;
                break;
            case 3:
                c4 = color;
                break;

        }
    }

    // get color, for specific position
    public Color getValue(int pos) {// lav dette til switchcase
        switch (pos) {
            case 0:
                return c1;
            case 1:
                return c2;
            case 2:
                return c3;
            case 3:
                return c4;
            default:
                throw new Error("Pos out of bound. Must be in range of 0-3");
        }

    }

    @Override
    public boolean equals(Object o) {
        MmPossibility other = o instanceof MmPossibility ? (MmPossibility) o : null;

        if (other == null)
            return false;
        return !(c1 != other.getValue(0) ||
                c2 != other.getValue(1) ||
                c3 != other.getValue(2) ||
                c4 != other.getValue(3));
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        MmPossibility other = o instanceof MmPossibility ? (MmPossibility) o : null;
        if (other == null) {
            throw new Error("Cannot compare MmPossibility to something else");
        }
        return hashCode() - other.hashCode();
    }

    @Override
    public int hashCode() {
        return c1.value * 1000 + c2.value * 100 + c3.value * 10 + c4.value;
    }
}
