package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.gremlin.pipes.transform.QueryPipe;
import com.tinkerpop.pipes.util.StartPipe;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFluentUtilityTest extends TestCase {


    public void testBackRemove() {

        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinPipeline pipeline = new GremlinPipeline(graph.getVertex(1)).out("knows").property("name");
        assertEquals(pipeline.size(), 3);
        assertEquals(GremlinFluentUtility.removeEdgeQueryOptimizationPipes(pipeline).size(), 0);
        assertEquals(pipeline.size(), 3);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", "0.5");
        assertEquals(pipeline.size(), 3);
        assertEquals(GremlinFluentUtility.removeEdgeQueryOptimizationPipes(pipeline).size(), 2);
        assertEquals(pipeline.size(), 1);

        pipeline = new GremlinPipeline(graph.getVertex(1)).has("name", "marko").outE("knows").has("weight", "0.5").has("weight", Tokens.T.lt, "0.7");
        assertEquals(pipeline.size(), 5);
        assertEquals(GremlinFluentUtility.removeEdgeQueryOptimizationPipes(pipeline).size(), 3);
        assertEquals(pipeline.size(), 2);
    }

    public void testTest() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinPipeline pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", "0.5").inV();
        assertEquals(pipeline.size(), 2);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        //QueryPipe pipe = (QueryPipe) pipeline.get(1);
    }

}
