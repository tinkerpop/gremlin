package com.tinkerpop.gremlin.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.Function;

import javax.script.ScriptContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddEdgeFunctionTest extends BaseTest {

    public void testAddEdge() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Edge> function = new AddEdgeFunction();
        assertEquals(function.getFunctionName(), "add-e");
        this.stopWatch();
        Atom<Edge> atom = function.compute(createUnaryArgs(graph, null, graph.getVertex("1"), "co-developer", graph.getVertex("6")), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isEdge());
        assertEquals(atom.getValue().getOutVertex().getId(), "1");
        assertEquals(atom.getValue().getInVertex().getId(), "6");
        assertEquals(atom.getValue().getLabel(), "co-developer");

        this.stopWatch();
        atom = function.compute(createUnaryArgs(null, graph.getVertex("1"), "co-developer", graph.getVertex("4")), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isEdge());
        assertEquals(atom.getValue().getOutVertex().getId(), "1");
        assertEquals(atom.getValue().getInVertex().getId(), "4");
        assertEquals(atom.getValue().getLabel(), "co-developer");


        Map map = new HashMap();
        map.put("weight", 0.5d);
        this.stopWatch();
        atom = function.compute(createUnaryArgs(map, graph.getVertex("1"), "co-worker", graph.getVertex("2")), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isEdge());
        assertEquals(atom.getValue().getOutVertex().getId(), "1");
        assertEquals(atom.getValue().getInVertex().getId(), "2");
        assertEquals(atom.getValue().getLabel(), "co-worker");
        assertEquals(atom.getValue().getProperty("weight"), 0.5d);

    }
}
