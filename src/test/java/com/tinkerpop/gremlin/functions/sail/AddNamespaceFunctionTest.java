package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.blueprints.pgm.impls.sail.impls.MemoryStoreSailGraph;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.gremlin.functions.Function;

import javax.script.ScriptContext;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class AddNamespaceFunctionTest extends BaseTest {

    public void testAddNamespace() {
        SailGraph graph = new MemoryStoreSailGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Object> function = new AddNamespaceFunction();
        this.stopWatch();
        Atom<Object> atom = function.compute(createUnaryArgs(graph, "tp", "http://tinkerpop.com"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace added", this.stopWatch());
        assertNull(atom.getValue());
        assertEquals(graph.getNamespaces().get("tp"), "http://tinkerpop.com");

        this.stopWatch();
        atom = function.compute(createUnaryArgs("marko", "http://markorodriguez.com"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace added", this.stopWatch());
        assertTrue(atom.isNull());
        assertEquals(graph.getNamespaces().get("marko"), "http://markorodriguez.com");
        assertEquals(graph.getNamespaces().get("tp"), "http://tinkerpop.com");

        graph.shutdown();

    }
}
