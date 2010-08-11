package com.tinkerpop.gremlin.compiler.functions.jung;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.BaseTest;

import java.util.Map;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class JungTest extends BaseTest {

    public Vertex getHighestRankVertex(Map ranking) {
        Vertex highVertex = null;
        double highValue = 0.0d;
        for (Vertex key : (Set<Vertex>) ranking.keySet()) {
            double temp = ((Number) ranking.get(key)).doubleValue();
            if (temp > highValue) {
                highValue = temp;
                highVertex = key;
            }
        }
        return highVertex;
    }

    public Vertex getLowestRankVertex(Map ranking) {
        Vertex lowVertex = null;
        double lowValue = 10.0d;
        for (Vertex key : (Set<Vertex>) ranking.keySet()) {
            double temp = ((Number) ranking.get(key)).doubleValue();
            if (temp < lowValue) {
                lowValue = temp;
                lowVertex = key;
            }
        }
        return lowVertex;
    }

    public Double getHighestRankValue(Map ranking) {
        double highValue = 0.0d;
        for (Vertex key : (Set<Vertex>) ranking.keySet()) {
            double temp = ((Number) ranking.get(key)).doubleValue();
            if (temp > highValue) {
                highValue = temp;
            }
        }
        return highValue;
    }

    public Double getLowestRankValue(Map ranking) {
        double lowValue = 10.0d;
        for (Vertex key : (Set<Vertex>) ranking.keySet()) {
            double temp = ((Number) ranking.get(key)).doubleValue();
            if (temp < lowValue) {
                lowValue = temp;
            }
        }
        return lowValue;
    }
}