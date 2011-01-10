package com.tinkerpop.gremlin.jsr223;

import com.tinkerpop.blueprints.pgm.impls.tg.TinkerGraphFactory;
import com.tinkerpop.gremlin.BaseTest;

import javax.script.ScriptEngine;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinScriptEngineTest extends BaseTest {

    public void testGremlinLoading() throws Exception {
        ScriptEngine engine = new GremlinScriptEngine();
        List list = new ArrayList();
        engine.put("g", TinkerGraphFactory.createTinkerGraph());
        engine.put("list", list);
        assertEquals(list.size(), 0);
        engine.eval("g.v(1).outE.inV >> list");
        assertEquals(list.size(), 3);
    }

    public void testImports() throws Exception {
        ScriptEngine engine = new GremlinScriptEngine();
        //todo: engine.eval("new TinkerGraph()");
    }

}
