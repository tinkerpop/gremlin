package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinEvaluatorTest extends BaseTest {

    public void testSettingGraphVariable() {
        Graph graph = new TinkerGraph();
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertTrue(true);
        try {
            ge.setVariable(Tokens.GRAPH_VARIABLE, new ArrayList());
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }
        try {
            ge.setVariable(Tokens.GRAPH_VARIABLE, "a graph");
            assertFalse(true);
        } catch (EvaluationException e) {
            assertTrue(true);
        }

    }

    public void testUnmodifiableListChecker() {
        assertTrue(FunctionHelper.isUnmodifiable(Collections.EMPTY_LIST));
        assertFalse(FunctionHelper.isUnmodifiable(new ArrayList()));
    }

    /* public void testInputStream() throws Exception {
       stopWatch();
       GremlinEvaluator ge = new GremlinEvaluator();
       List result = ge.evaluate(GremlinEvaluator.class.getResourceAsStream("examples.grm"));
       System.out.println(result);
       System.out.println(stopWatch());
   } */
}
