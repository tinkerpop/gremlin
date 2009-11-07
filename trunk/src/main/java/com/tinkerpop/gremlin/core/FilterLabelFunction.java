package com.tinkerpop.gremlin.core;

import com.tinkerpop.gremlin.Edge;
import com.tinkerpop.gremlin.Function;
import com.tinkerpop.gremlin.Pair;

import java.util.Set;
import java.util.HashSet;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class FilterLabelFunction implements Function<Pair<Set<Edge>,String>, Set<Edge>> {

    public static final String NAME = "#L";

    public Set<Edge> evaluate(final Pair<Set<Edge>,String> input) {
        Set<Edge> returnSet = new HashSet<Edge>();
        String regex = input.getSecond();
        for(Edge edge : input.getFirst()){
            if(edge.getEdgeLabel().matches(regex)) {
                returnSet.add(edge);
            }
        }
        return returnSet;
    }

    public String getName() {
        return NAME;
    }
}
