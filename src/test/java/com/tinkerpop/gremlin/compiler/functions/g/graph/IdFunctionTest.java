package com.tinkerpop.gremlin.compiler.functions.g.graph;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.TestHelper;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import junit.framework.TestCase;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IdFunctionTest extends TestCase {

    public void testId() {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        Function function = new IdFunction();
        assertEquals(function.getFunctionName(), "id");
        Atom atom = function.compute(TestHelper.createUnaryArgs(graph, "1"));
        assertTrue(atom.isVertex());
        assertEquals(((Vertex) atom.getValue()).getProperty("name"), "marko");

    }
}
