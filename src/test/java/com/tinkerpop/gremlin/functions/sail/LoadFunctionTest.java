package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.XPathEvaluator;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailGraph;
import junit.framework.TestCase;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunctionTest extends TestCase {

    public void testLoadTriples() {
        //TODO: do!
        Graph graph = new SailGraph(new MemoryStore());
        XPathEvaluator xe = new XPathEvaluator();
        graph.shutdown();
    }

}
