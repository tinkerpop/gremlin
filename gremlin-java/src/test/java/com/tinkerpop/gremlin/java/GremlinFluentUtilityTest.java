package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.Tokens;
import com.tinkerpop.gremlin.pipes.filter.IntervalFilterPipe;
import com.tinkerpop.gremlin.pipes.filter.PropertyFilterPipe;
import com.tinkerpop.gremlin.pipes.transform.BothVerticesPipe;
import com.tinkerpop.gremlin.pipes.transform.InVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.OutEdgesPipe;
import com.tinkerpop.gremlin.pipes.transform.OutVertexPipe;
import com.tinkerpop.gremlin.pipes.transform.QueryPipe;
import com.tinkerpop.pipes.filter.FilterPipe;
import com.tinkerpop.pipes.filter.RangeFilterPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectFunctionPipe;
import com.tinkerpop.pipes.transform.IdentityPipe;
import com.tinkerpop.pipes.util.StartPipe;
import junit.framework.TestCase;

import java.util.Iterator;

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

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", 0.5);
        assertEquals(pipeline.size(), 3);
        assertEquals(GremlinFluentUtility.removeEdgeQueryOptimizationPipes(pipeline).size(), 2);
        assertEquals(pipeline.size(), 1);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", 0.5)._();
        assertEquals(pipeline.size(), 4);
        assertEquals(GremlinFluentUtility.removeEdgeQueryOptimizationPipes(pipeline).size(), 3);
        assertEquals(pipeline.size(), 1);

        pipeline = new GremlinPipeline(graph.getVertex(1)).has("name", "marko").outE("knows").has("weight", 0.5).has("weight", Tokens.T.lt, 0.7);
        assertEquals(pipeline.size(), 5);
        assertEquals(GremlinFluentUtility.removeEdgeQueryOptimizationPipes(pipeline).size(), 3);
        assertEquals(pipeline.size(), 2);

    }

    public void testOptimization() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinPipeline pipeline = new GremlinPipeline(graph.getVertex(1)).outE().inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 3);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE()._().inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 4);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", 0.5).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 4);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", 0.5).interval("since", 10, 2).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 5);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof IdentityPipe);
        assertTrue(pipeline.get(4) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows").has("weight", 0.5).interval("since", 10, 2).outV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 5);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof IdentityPipe);
        assertTrue(pipeline.get(4) instanceof OutVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).inE("knows", "created").has("weight", 0.5).interval("since", 10, 2).outV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 5);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof IdentityPipe);
        assertTrue(pipeline.get(4) instanceof OutVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).bothE("knows", "created").has("weight", 0.5).interval("since", 10, 2).bothV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 5);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof IdentityPipe);
        assertTrue(pipeline.get(4) instanceof BothVerticesPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).bothE("knows", "created").has("weight", 0.5)._().interval("since", 10, 2).bothV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 6);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof IdentityPipe);
        assertTrue(pipeline.get(4) instanceof IdentityPipe);
        assertTrue(pipeline.get(5) instanceof BothVerticesPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE("knows", "created").has("weight", 0.5)._().interval("since", 10, 2).range(1, 10).bothV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 7);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof PropertyFilterPipe);
        assertTrue(pipeline.get(3) instanceof IdentityPipe);
        assertTrue(pipeline.get(4) instanceof IntervalFilterPipe);
        assertTrue(pipeline.get(5) instanceof RangeFilterPipe);
        assertTrue(pipeline.get(6) instanceof BothVerticesPipe);
    }

    public void testNoOptimizations() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();

        GremlinPipeline pipeline = new GremlinPipeline(graph.getVertex(1)).outE().sideEffect(null).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 4);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof SideEffectFunctionPipe);
        assertTrue(pipeline.get(3) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE().filter(null).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 4);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof FilterPipe);
        assertTrue(pipeline.get(3) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).outE().has("weight", 0.5).filter(null).has("date", 2012).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 6);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof PropertyFilterPipe);
        assertTrue(pipeline.get(3) instanceof FilterPipe);
        assertTrue(pipeline.get(4) instanceof PropertyFilterPipe);
        assertTrue(pipeline.get(5) instanceof InVertexPipe);


        // TEST OPTIMIZE(BOOLEAN) PARAMETERIZATION
        pipeline = new GremlinPipeline(graph.getVertex(1)).optimize(false).outE("knows").has("weight", 0.5).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 4);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof OutEdgesPipe);
        assertTrue(pipeline.get(2) instanceof PropertyFilterPipe);
        assertTrue(pipeline.get(3) instanceof InVertexPipe);

        pipeline = new GremlinPipeline(graph.getVertex(1)).optimize(true).outE("knows").has("weight", 0.5).inV();
        //System.out.println(pipeline);
        assertEquals(pipeline.size(), 4);
        assertTrue(pipeline.get(0) instanceof StartPipe);
        assertTrue(pipeline.get(1) instanceof QueryPipe);
        assertTrue(pipeline.get(2) instanceof IdentityPipe);
        assertTrue(pipeline.get(3) instanceof InVertexPipe);
    }

    public void testNullStart() {
        GremlinPipeline pipeline;
        try {
            pipeline = new GremlinPipeline(null);
        } catch (NullPointerException e) {
        }
        try {
            pipeline = new GremlinPipeline(null, false);
            fail();
        } catch (NullPointerException e) {
        }
        try {
            pipeline = new GremlinPipeline();
            pipeline.start(null);
            fail();
        } catch (NullPointerException e) {
        }
        try {
            pipeline = new GremlinPipeline();
            pipeline.setStarts((Iterator) null);
            fail();
        } catch (NullPointerException e) {
        }

    }

}
