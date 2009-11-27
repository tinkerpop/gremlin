package com.tinkerpop.gremlin.db.neo;

import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.model.Element;
import junit.framework.TestCase;
import org.neo4j.api.core.NeoService;
import org.neo4j.api.core.Node;
import org.neo4j.api.core.Transaction;
import org.neo4j.util.index.IndexService;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class NeoWalkerTest extends TestCase {

    public void testJXPath() throws Exception {
        GratefulNeoGraph gng = new GratefulNeoGraph();
        gng.loadGratefulDeadGraph();


    }


}
