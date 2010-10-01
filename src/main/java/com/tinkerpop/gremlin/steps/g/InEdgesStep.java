package com.tinkerpop.gremlin.steps.g;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.steps.Step;
import com.tinkerpop.pipes.pgm.VertexEdgePipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class InEdgesStep extends VertexEdgePipe implements Step<Vertex, Edge> {

    private static final String STEP_NAME = "inE";

    public InEdgesStep() {
        super(Step.IN_EDGES);
    }

    public String getStepName() {
        return STEP_NAME;
    }
}
