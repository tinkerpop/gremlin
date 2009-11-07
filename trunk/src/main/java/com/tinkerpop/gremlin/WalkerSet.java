package com.tinkerpop.gremlin;

import java.util.Collection;
import java.util.TreeSet;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class WalkerSet {

    protected TreeSet<Walker> walkers;

    public WalkerSet() {
        this.walkers = new TreeSet<Walker>();
    }

    public void addWalker(Walker w) {
        this.walkers.add(w);
    }

    public void removeWalker(Walker w) {
        this.walkers.remove(w);
    }

    public void removeWalkers(Collection<Walker> walkers) {
        this.walkers.removeAll(walkers);
    }

    public void removeAllWalkers() {
        this.walkers.clear();
    }

    public TreeSet<Walker> getWalkers() {
        return this.walkers;
    }

    public int getSize() {
        return this.walkers.size();
    }
}
