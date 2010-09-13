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
public class RemoveNamespaceFunctionTest extends BaseTest {

    public void testRemoveNamespace() {
        SailGraph graph = new MemoryStoreSailGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put(Tokens.GRAPH_VARIABLE, new Atom<Graph>(graph));

        Function<Object> function = new RemoveNamespaceFunction();
        assertNotNull(graph.getNamespaces().get("rdf"));
        this.stopWatch();
        Atom<Object> atom = function.compute(createUnaryArgs(graph, "rdf"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace removed", this.stopWatch());
        assertNull(atom.getValue());
        assertNull(graph.getNamespaces().get("rdf"));

        assertNotNull(graph.getNamespaces().get("rdfs"));
        this.stopWatch();
        atom = function.compute(createUnaryArgs("rdfs"), context);
        printPerformance(function.getFunctionName() + " function", 1, "namespace removed", this.stopWatch());
        assertTrue(atom.isNull());
        assertNull(graph.getNamespaces().get("rdfs"));

        graph.shutdown();
    }
}
