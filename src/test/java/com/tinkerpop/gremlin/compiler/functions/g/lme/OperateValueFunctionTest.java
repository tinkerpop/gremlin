package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.HashMap;
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
        printPerformance(function.getFunctionName() + " function", 100, "map additions", this.stopWatch());
        assertEquals(atom.getValue(), 100.0);
        assertEquals(marko.getProperty("counter"), 1);
        assertEquals(marko.getProperty("counter2"), 100.0);

        this.stopWatch();
        for (int i = 0; i < 100; i++) {
            atom = function.compute(createUnaryArgs("-", marko, "counter2", 1), context);
        }
        printPerformance(function.getFunctionName() + " function", 100, "map subtractions", this.stopWatch());
        assertEquals(atom.getValue(), 0.0);
        assertEquals(marko.getProperty("counter"), 1);
        assertEquals(marko.getProperty("counter2"), 0.0);
    }
}