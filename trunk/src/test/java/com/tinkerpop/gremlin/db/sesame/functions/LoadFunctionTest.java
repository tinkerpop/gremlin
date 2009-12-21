package com.tinkerpop.gremlin.db.sesame.functions;

import junit.framework.TestCase;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.XPathEvaluator;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class LoadFunctionTest extends TestCase {

    public void testLoadTriples() {
        Graph graph = new SesameGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        graph.shutdown();
    }
    
}
