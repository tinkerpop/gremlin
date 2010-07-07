package com.tinkerpop.gremlin.compiler.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class Range implements Iterable {

    private final int minimum;
    private final int maximum;
    
    private final List<Double> range = new ArrayList<Double>(); 

    /**
     * Simple prototype of the Range class
     *
     * foreach $i in 0..10
     *   g:print($i)
     * end
     */
    public Range(final int min, final int max) {
        this.minimum = min;
        this.maximum = max;
        this.fillRangeList();
    }

    public Range(final String min, final String max) throws RuntimeException {
        this.minimum = new Integer(min);
        this.maximum = new Integer(max);
        this.fillRangeList();
    }
    
    public Iterator<Double> iterator() {
        return this.range.iterator();
    }

    public int getMinimum() {
        return this.minimum;
    }

    public int getMaximum() {
        return this.maximum;
    }

    private void fillRangeList() {
        for (int i = this.minimum; i < this.maximum; i++) {
            this.range.add(new Double(i));
        }
    }

    public String toString() {
        return this.range.toString();
    }
}
