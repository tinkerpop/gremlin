package com.tinkerpop.gremlin.db.sail.functions;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.db.sail.SailGraph;
import com.tinkerpop.gremlin.model.Graph;
import junit.framework.TestCase;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunctionTest extends TestCase {

    public void testLoadTriples() {
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        graph.shutdown();
    }

}
