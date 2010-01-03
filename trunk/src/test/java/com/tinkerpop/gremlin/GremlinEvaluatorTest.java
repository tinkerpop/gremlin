package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.tg.TinkerGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.Tokens;
import com.tinkerpop.gremlin.statements.EvaluationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinEvaluatorTest extends BaseTest {

    private int MAP_ITERATIONS = 10000;

    public void testMapTimes() {

        // WARM UP THE PROCESSOR
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            ge.evaluate("$m[@name='marko'] := $m[@name='marko'] + 1");
        }
        //System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            ge.evaluate("$n := 'marko'");
            ge.evaluate("$m[@name=$n] := $m[@name=$n] + 1");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            ge.evaluate("$m[@name='marko'] := $m[@name='marko'] + 1");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            ge.evaluate("$m/@marko := $m/@marko + 1");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            ge.evaluate("g:assign($m, 'marko', $m/@marko + 1)");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            ge.evaluate("'marko'[g:op-value('+',$m, ., 1)]");
        }
        System.out.println(stopWatch());

        Map map = new HashMap();
        map.put("marko", 0);
        stopWatch();
        for (int i = 0; i < MAP_ITERATIONS; i++) {
            map.put("marko", (Integer) map.get("marko") + 1);
        }
        System.out.println(stopWatch());

    }

    public void testSettingGraphVariable() {
        Graph graph = new TinkerGraph();
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.setVariable(Tokens.GRAPH_VARIABLE, graph);
        assertTrue(true);
        try {
            ge.setVariable(Tokens.GRAPH_VARIABLE, new ArrayList());
            assertFalse(true);
        } catch(EvaluationException e) {
            assertTrue(true);
        }
        try {
            ge.setVariable(Tokens.GRAPH_VARIABLE, "a graph");
            assertFalse(true);
        } catch(EvaluationException e) {
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
