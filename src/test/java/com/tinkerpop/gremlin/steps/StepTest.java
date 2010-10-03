package com.tinkerpop.gremlin.steps;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.pipes.IdentityPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.pgm.VertexEdgePipe;

import java.util.Arrays;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class StepTest extends BaseTest {

    public void testStepToPipeWithArguments() {
        Step step = new Step("outE", VertexEdgePipe.class, new Object[]{VertexEdgePipe.Step.OUT_EDGES});
        assertEquals(step.getStepName(), Tokens.OUT_E);


        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe pipe = step.createPipe();
        pipe.setStarts(Arrays.asList(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            Edge edge = (Edge) pipe.next();
            assertTrue(edge.getLabel().equals("knows") || edge.getLabel().equals("created"));
        }
        assertEquals(3, counter);
    }

    public void testStepToPipeWithNoArguments() {
        Step step = new Step(".", IdentityPipe.class, null);
        assertEquals(step.getStepName(), Tokens.IDENTITY);

        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe pipe = step.createPipe();
        pipe.setStarts(Arrays.asList(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next(), graph.getVertex(1));
        }
        assertEquals(1, counter);
    }

    public void testStepToPipeWithNoArguments2() {
        Step step = new Step(".", IdentityPipe.class, new Object[]{});
        assertEquals(step.getStepName(), Tokens.IDENTITY);

        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Pipe pipe = step.createPipe();
        pipe.setStarts(Arrays.asList(graph.getVertex(1)));
        int counter = 0;
        while (pipe.hasNext()) {
            counter++;
            assertEquals(pipe.next(), graph.getVertex(1));
        }
        assertEquals(1, counter);
    }

}
