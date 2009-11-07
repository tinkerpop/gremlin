package com.tinkerpop.gremlin;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class Evaluator {

    private WalkerSet walkerSet;

    public Evaluator(WalkerSet walkerSet) {
        this.walkerSet = walkerSet;
    }

    public void execute(int numberOfSteps) {
        for (int i = 0; i < numberOfSteps; i++) {
            this.step();
            if (this.walkerSet.getSize() == 0) {
                return;
            }
        }
    }

    public void step() {

        List<Walker> toRemove = new LinkedList<Walker>();
        for (Walker w : this.walkerSet.getWalkers()) {
            w.evaluate();
        }
        this.walkerSet.removeWalkers(toRemove);
    }
}
