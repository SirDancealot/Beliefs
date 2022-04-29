package ai.gr64.belief;

public interface Possibilities {
    Possibilities innerJoin(Possibilities other);
    Possibilities outerJoin(Possibilities other);
    Possibilities exclusive(Possibilities other);
    Possibilities not();
}
