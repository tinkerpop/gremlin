package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OperateValueFunctionTest extends BaseTest {

    public void testOperateValueMap() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Number> function = new OperateValueFunction();
        Map map = new HashMap();

        this.stopWatch();
        Atom<Number> atom = function.compute(createUnaryArgs("+", map, "pavel", 1), context);
        printPerformance(function.getFunctionName() + " function", 1, "map addition", this.stopWatch());
        assertEquals(atom.getValue(), 1);
        assertEquals(map.get("pavel"), 1);
        assertEquals(map.size(), 1);

        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("+", map, "marko", 1), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "map additions", this.stopWatch());
        assertEquals(atom.getValue(), 100);
        assertEquals(map.get("pavel"), 1);
        assertEquals(map.get("marko"), 100);
        assertEquals(map.size(), 2);

        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("-", map, "marko", 1), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "map subtractions", this.stopWatch());
        assertEquals(atom.getValue(), 0);
        assertEquals(map.get("pavel"), 1);
        assertEquals(map.get("marko"), 0);
        assertEquals(map.size(), 2);

    }

    public void testOperateValueElement() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getVariableLibrary().declare(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Number> function = new OperateValueFunction();
        Vertex marko = graph.getVertex(1);

        this.stopWatch();
        Atom<Number> atom = function.compute(createUnaryArgs("+", marko, "counter", 1), context);
        printPerformance(function.getFunctionName() + " function", 1, "vertex addition", this.stopWatch());
        assertEquals(atom.getValue(), 1);
        assertEquals(marko.getProperty("counter"), 1);

        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("+", marko, "counter2", 1.0), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "vertex additions", this.stopWatch());
        assertEquals(atom.getValue(), 100.0);
        assertEquals(marko.getProperty("counter"), 1);
        assertEquals(marko.getProperty("counter2"), 100.0);

        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("-", marko, "counter2", 1), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "vertex subtractions", this.stopWatch());
        assertEquals(atom.getValue(), 0.0);
        assertEquals(marko.getProperty("counter"), 1);
        assertEquals(marko.getProperty("counter2"), 0.0);
    }

    public void testOperateValueList() {
        GremlinScriptContext context = new GremlinScriptContext();

        Function<Number> function = new OperateValueFunction();
        List list = new ArrayList();
        list.add(0);

        this.stopWatch();
        Atom<Number> atom = function.compute(createUnaryArgs("+", list, 0, 1), context);
        printPerformance(function.getFunctionName() + " function", 1, "list addition", this.stopWatch());
        assertEquals(atom.getValue(), 1);
        assertEquals(list.get(0), 1);

        list.add(0);
        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("+", list, 1, 1.0), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "list additions", this.stopWatch());
        assertEquals(atom.getValue(), 100.0);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 100.0);

        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("-", list, 1, 1), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "list subtractions", this.stopWatch());
        assertEquals(atom.getValue(), 0.0);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 0.0);
    }

    public void testOperateValueInline() throws Exception {
        GremlinScriptContext context = new GremlinScriptContext();
        Map map = new HashMap();
        context.getVariableLibrary().declare("$m", new Atom<Map>(map));

        List results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:op-value('+',$m,.,1.0)]", context, true);
        assertNull(results);
        assertEquals(map.get(1), 4.0f);
        assertEquals(map.get(2), 5.0f);
        assertNull(map.get(3));

        results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:p(g:op-value('+',$m,.,1.0))]", context, true);
        assertEquals(results.size(), 9);
        assertEquals(map.get(1), 8.0f);
        assertEquals(map.get(2), 10.0f);
        assertNull(map.get(3));

        map = new HashMap();
        context.getVariableLibrary().declare("$m", new Atom<Map>(map));
        results = evaluateGremlinScriptIterable("g:list(1,1,2,1,1,2,2,2,2)[g:p(g:p(g:op-value('+',$m,.,1.0)))][0..3]", context, true);
        assertEquals(results.size(), 3);
        assertEquals(results.get(0), 1);
        assertEquals(results.get(1), 1);
        assertEquals(results.get(2), 2);
        assertEquals(map.get(1), 4.0f);
        assertEquals(map.get(2), 5.0f);
        assertNull(map.get(3));


    }
}