package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class KeyVertexFunctionTest extends BaseTest {

    public void testKey() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        
        Function<Iterable<Element>> function = new KeyVertexFunction();
        assertEquals(function.getFunctionName(), "key-v");
        this.stopWatch();
        Atom<Iterable<Element>> atom = function.compute(createUnaryArgs(graph, "name", "marko"), context);
        printPerformance(function.getFunctionName() + " function", 1, "evaluation", this.stopWatch());
        assertTrue(atom.isIterable());
        assertEquals(count(atom.getValue()), 1);

    }
}
