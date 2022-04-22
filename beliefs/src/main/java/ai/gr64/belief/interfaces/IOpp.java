package ai.gr64.belief.interfaces;

import ai.gr64.belief.Possibilities;

public interface IOpp {
   public Possibilities evaluate();
   public void addOpp(IOpp opp);
   public boolean isFull();
}
