package com.tinkerpop.gremlin.db.sesame;

import junit.framework.TestCase;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.sail.memory.MemoryStore;
import org.openrdf.sail.SailConnection;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameGraphTest extends TestCase {

    public void testLoadTinkerGraphExample() throws Exception {
        MemoryStore sail = new MemoryStore();
        sail.initialize();
        Repository repo = new SailRepository(sail);
        RepositoryConnection connection = repo.getConnection();
        connection.add(SesameGraph.class.getResourceAsStream("graph-example-1.ntriple"), null, RDFFormat.NTRIPLES);
        connection.commit();
        connection.close();
        SailConnection sc = sail.getConnection();
        assertTrue(sc.getStatements(null,null,null,false).hasNext());
        sail.shutDown();


    }
}
