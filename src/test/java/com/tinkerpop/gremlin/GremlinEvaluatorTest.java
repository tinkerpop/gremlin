package com.tinkerpop.gremlin;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinEvaluatorTest extends BaseTest {

    public void testRootVariable() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertEquals(ge.evaluate("$_ := g:id('1')").get(0), graph.getVertex("1"));
        ge.evaluate("./outE");
        assertEquals(ge.evaluate("$_ := g:id('2')").get(0), graph.getVertex("2"));
        assertEquals(ge.evaluate(".").get(0), graph.getVertex("2"));
    }

    public void testSettingGraphVariable() {
        Graph graph = new TinkerGraph();
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);
        assertTrue(true);
        try {
            ge.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, new ArrayList());
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            ge.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, "a graph");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
    }

    public void testRemovingVariable() {
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.getVariables().declareVariable("$marko", "marko");
        assertEquals(ge.getVariables().getVariable("$marko"), "marko");
        ge.getVariables().undeclareVariable("$marko");
        assertFalse(ge.getVariables().isDeclaredVariable("$marko"));
        assertNull(ge.getVariables().getVariable("$marko"));
    }

    public void testUnmodifiableListChecker() {
        assertTrue(FunctionHelper.isUnmodifiable(Collections.EMPTY_LIST));
        assertFalse(FunctionHelper.isUnmodifiable(new ArrayList()));
    }

    public void testGraphVariable() {
        // this is a test for the variable issue that occurs when a new path context is created.
        GremlinEvaluator ge = new GremlinEvaluator();
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        ge.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, graph);

        try {
            ge.evaluate("$_ := g:list(g:id('1'), g:id('2'))");
            ge.evaluate("./bothE");
            assertEquals(ge.evaluate("g:list(g:key('name','marko'))").get(0), graph.getVertex('1'));
            assertTrue(true);
        } catch (Exception e) {
            assertFalse(true);
        }
    }
}
