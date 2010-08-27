package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;

import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class ForceFunctionTest  extends BaseTest {

    public void testGPathCases() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();

        context.getVariableLibrary().putAtom(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));
        context.getVariableLibrary().putAtom(Tokens.ROOT_VARIABLE, new Atom<Vertex>(graph.getVertex(1)));

        Object result = evaluateGremlinScriptPrimitive("g:force(./outE/inV[g:p($x := .)])", context, true);
        assertNull(result);

        Object x = context.getVariableLibrary().get("$x");
        assertTrue(x instanceof Vertex);
        String name = (String) ((Vertex) x).getProperty("name");
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        result = evaluateGremlinScriptPrimitive("g:force(./outE/inV[g:p($x := ./@name)])", context, true);
        assertNull(result);

        x = context.getVariableLibrary().get("$x");
        assertTrue(x instanceof String);
        name = (String) x;
        assertTrue(name.equals("vadas") || name.equals("josh") || name.equals("lop"));

        evaluateGremlinScriptPrimitive("$y := g:map()", context, false);
        result = evaluateGremlinScriptPrimitive("g:force(./outE[g:p(g:op-value('+', $y, ./inV/@name, ./@weight))]/inV)", context, true);
        assertNull(result);
        // results should be double as we iterating two times
        Map y = (Map) context.getVariableLibrary().get("$y");
        assertEquals(y.size(), 3);
        assertEquals(y.get("lop"), 0.4f);
        assertEquals(y.get("vadas"), 0.5f);
        assertEquals(y.get("josh"), 1.0f);

        evaluateGremlinScriptPrimitive("$y := g:map()", context, false);
        evaluateGremlinScriptIterable("repeat 2\ng:force(./outE[g:p(g:op-value('+', $y, ./inV/@name, ./@weight))]/inV)\nend", context, true);
        y = (Map) context.getVariableLibrary().get("$y");
        assertEquals(y.size(), 3);
        assertEquals(y.get("lop"), 0.8f);
        assertEquals(y.get("vadas"), 1.0f);
        assertEquals(y.get("josh"), 2.0f);

        evaluateGremlinScriptPrimitive("$y := 0", context, false);
        evaluateGremlinScriptIterable("repeat 2\ng:force(./outE[g:p($y := $y + 1)]/inV)\nend", context, true);
        Object count = context.getVariableLibrary().get("$y");
        assertEquals(count, 6);
    }
}
