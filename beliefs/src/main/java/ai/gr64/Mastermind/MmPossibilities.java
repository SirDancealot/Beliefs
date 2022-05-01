package ai.gr64.Mastermind;

import java.util.HashSet;

import ai.gr64.Mastermind.Game.Color;
import ai.gr64.belief.Possibilities;

public class MmPossibilities implements Possibilities {
    public static final MmPossibilities AllPossibilities = allPossibilities();

    private HashSet<MmPossibility> possibilities = new HashSet<MmPossibility>();

    public MmPossibilities(Color[] c1, Color[] c2, Color[] c3, Color[] c4) {
        for (Color color1 : c1) {
            for (Color color2 : c2) {
                for (Color color3 : c3) {
                    for (Color color4 : c4) {
                        possibilities.add(new MmPossibility(color1, color2, color3, color4));
                    }
                }
            }
        }
    }

    public MmPossibilities() {
    }

    public void AddPossibility(MmPossibility pos) {
        possibilities.add(pos);
    }

    @Override
    public Possibilities innerJoin(Possibilities other) {
        MmPossibilities o = other instanceof MmPossibilities ? (MmPossibilities) other : null;
        if (o == null) {
            throw new Error("Cannot compare two different types of possibilities");
        }

        MmPossibilities joined = new MmPossibilities();

        for (MmPossibility mmPossibility : possibilities) {
            if (o.contains(mmPossibility))
                joined.AddPossibility(mmPossibility);
        }

        return joined;
    }

    @Override
    public Possibilities outerJoin(Possibilities other) {
        MmPossibilities o = other instanceof MmPossibilities ? (MmPossibilities) other : null;
        if (o == null) {
            throw new Error("Cannot compare two different types of possibilities");
        }

        MmPossibilities joined = new MmPossibilities();
        joined.addAll(o);

        for (MmPossibility mmPossibility : possibilities) {
            if (!joined.contains(mmPossibility))
                joined.AddPossibility(mmPossibility);
        }

        return joined;
    }

    @Override
    public Possibilities exclusive(Possibilities other) {
        MmPossibilities o = other instanceof MmPossibilities ? (MmPossibilities) other : null;
        if (o == null) {
            throw new Error("Cannot compare two different types of possibilities");
        }

        MmPossibilities joined = new MmPossibilities();
        joined.addAll(o);

        for (MmPossibility mmPossibility : possibilities) {
            if (!joined.remove(mmPossibility))
                joined.AddPossibility(mmPossibility);
        }

        return joined;
    }

    @Override
    public Possibilities not() {
        MmPossibilities not = new MmPossibilities();
        not.addAll(AllPossibilities);

        for (MmPossibility mmPossibility : possibilities) {
            not.remove(mmPossibility);
        }

        return not;
    }

    private boolean contains(MmPossibility possibility) {
        return possibilities.contains(possibility);
    }

    private boolean remove(MmPossibility possibility) {
        return possibilities.remove(possibility);
    }

    private boolean addAll(MmPossibilities pos) {
        return possibilities.addAll(pos.getSet());
    }

    public HashSet<MmPossibility> getSet() {
        return possibilities;
    }

    private static MmPossibilities allPossibilities() {
        MmPossibilities pos = new MmPossibilities();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
                        pos.AddPossibility(new MmPossibility(Color.fromValue(i), Color.fromValue(j), Color.fromValue(k),
                                Color.fromValue(l)));
                    }
                }
            }
        }

        return pos;
    }

    public MmPossibility getPossibility(int index) {
        return (MmPossibility) possibilities.toArray()[index];
    }
}
