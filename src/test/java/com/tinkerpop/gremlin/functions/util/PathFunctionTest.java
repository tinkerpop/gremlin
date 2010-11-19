package com.tinkerpop.gremlin.functions.util;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerEdge;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.blueprints.pgm.impls.tg.TinkerVertex;
import com.tinkerpop.gremlin.BaseTest;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;

import javax.script.ScriptContext;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PathFunctionTest extends BaseTest {

    public void testBasicPath() throws Exception {
        Graph graph = TinkerGraphFactory.createTinkerGraph();
        GremlinScriptContext context = new GremlinScriptContext();
        context.getBindings(ScriptContext.ENGINE_SCOPE).put("$_", graph.getVertex(1));
        List<List> results = (List<List>) evaluateGremlinScriptIterable("g:path(./outE/inV/@name)", context, true);
        for (List path : results) {
            String name = (String) path.get(path.size() - 1);
            assertEquals(path.get(0), graph.getVertex(1));
            assertEquals(path.get(1).getClass(), TinkerEdge.class);
            assertEquals(path.get(2).getClass(), TinkerVertex.class);
            assertEquals(path.get(3).getClass(), String.class);
            if (name.equals("vadas")) {
                assertEquals(path.get(1), graph.getEdge(7));
                assertEquals(path.get(2), graph.getVertex(2));
                assertEquals(path.get(3), "vadas");
            } else if (name.equals("lop")) {
                assertEquals(path.get(1), graph.getEdge(9));
                assertEquals(path.get(2), graph.getVertex(3));
                assertEquals(path.get(3), "lop");
            } else if (name.equals("josh")) {
                assertEquals(path.get(1), graph.getEdge(8));
                assertEquals(path.get(2), graph.getVertex(4));
                assertEquals(path.get(3), "josh");
            } else {
                assertFalse(true);
            }
        }
    }
}
