package com.tinkerpop.gremlin.steps.g;

import com.tinkerpop.gremlin.steps.AbstractSteps;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinSteps extends AbstractSteps {

    public GremlinSteps() {
        // inE
        steps.add(new InEdgesStep());
        // outE
        steps.add(new OutEdgesStep());
        // bothE
        steps.add(new BothEdgesStep());
        // inV
        steps.add(new InVertexStep());
        // outV
        steps.add(new OutVertexStep());
        // bothV
        steps.add(new BothVerticesStep());
    }

}
