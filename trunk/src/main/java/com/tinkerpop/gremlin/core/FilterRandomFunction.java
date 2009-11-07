package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Function;
import com.tinkerpop.gremlin.Pair;

import java.util.Set;
import java.util.Random;
import java.util.HashSet;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public abstract class FilterRandomFunction implements Function<Pair<Set<Edge>,Integer>, Set<Edge>> {

    private static final Random random = new Random();

    /*public Set<Edge> evaluate(Pair<Set<Edge>,Integer> input) {
        Set<Edge> returnSet = new HashSet<Edge>();
        for(int i=0; i<input.getSecond(); i++) {
            int index = random.nextInt(input.getFirst().size());
            int counter = 0;
            for(Edge edge : input.getFirst()) {
                if(index == counter)
                    return
            }
        }

    }*/
}
