package com.tinkerpop.gremlin.steps.g;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.steps.Step;
import com.tinkerpop.pipes.pgm.EdgeVertexPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OutVertexStep extends EdgeVertexPipe implements Step<Edge, Vertex> {

    private static final String STEP_NAME = "outV";

    public OutVertexStep() {
        super(Step.OUT_VERTEX);
    }

    public String getStepName() {
        return STEP_NAME;
    }
}
