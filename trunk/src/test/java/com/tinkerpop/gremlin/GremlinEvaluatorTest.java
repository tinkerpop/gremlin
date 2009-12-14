package com.tinkerpop.gremlin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class GremlinEvaluatorTest extends BaseTest {

    public void testMapTimes() {

        // WARM UP THE PROCESSOR
        GremlinEvaluator ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        for (int i = 0; i < 20000; i++) {
            ge.evaluate("$m[@name='marko'] := $m[@name='marko'] + 1");
        }
        //System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < 20000; i++) {
            ge.evaluate("$n := 'marko'");
            ge.evaluate("$m[@name=$n] := $m[@name=$n] + 1");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < 20000; i++) {
            ge.evaluate("$m[@name='marko'] := $m[@name='marko'] + 1");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < 20000; i++) {
            ge.evaluate("$m/@marko := $m/@marko + 1");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < 20000; i++) {
            ge.evaluate("g:assign($m, 'marko', $m/@marko + 1)");
        }
        System.out.println(stopWatch());

        ge = new GremlinEvaluator();
        ge.evaluate("$m := g:map()");
        stopWatch();
        for (int i = 0; i < 20000; i++) {
            ge.evaluate("'marko'[g:add-value($m, 1)]");
        }
        System.out.println(stopWatch());

        Map map = new HashMap();
        map.put("marko", 0);
        stopWatch();
        for (int i = 0; i < 20000; i++) {
            map.put("marko", (Integer) map.get("marko") + 1);
        }
        System.out.println(stopWatch());

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
