package com.tinkerpop.gremlin.steps.g;

import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.steps.AbstractSteps;
import com.tinkerpop.gremlin.steps.Step;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.pgm.*;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinSteps extends AbstractSteps {

    public GremlinSteps() {
        this.steps.add(new Step(Tokens.IDENTITY, IdentityPipe.class, null));
        this.steps.add(new Step(Tokens.IN_E, VertexEdgePipe.class, new Object[]{VertexEdgePipe.Step.IN_EDGES}));
        this.steps.add(new Step(Tokens.OUT_E, VertexEdgePipe.class, new Object[]{VertexEdgePipe.Step.OUT_EDGES}));
        this.steps.add(new Step(Tokens.BOTH_E, VertexEdgePipe.class, new Object[]{VertexEdgePipe.Step.BOTH_EDGES}));
        this.steps.add(new Step(Tokens.IN_V, EdgeVertexPipe.class, new Object[]{EdgeVertexPipe.Step.IN_VERTEX}));
        this.steps.add(new Step(Tokens.OUT_V, EdgeVertexPipe.class, new Object[]{EdgeVertexPipe.Step.OUT_VERTEX}));
        this.steps.add(new Step(Tokens.BOTH_V, EdgeVertexPipe.class, new Object[]{EdgeVertexPipe.Step.BOTH_VERTICES}));
        this.steps.add(new Step(Tokens.V, GraphElementPipe.class, new Object[]{GraphElementPipe.ElementType.VERTEX}));
        this.steps.add(new Step(Tokens.E, GraphElementPipe.class, new Object[]{GraphElementPipe.ElementType.EDGE}));
        ///
        this.steps.add(new Step(Tokens.LABEL, LabelPipe.class, null));
        this.steps.add(new Step(Tokens.ID, IdPipe.class, null));
    }

}
