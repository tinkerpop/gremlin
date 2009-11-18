package com.tinkerpop.gremlin.db.sesame;

import junit.framework.TestCase;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFFormat;
import org.openrdf.sail.memory.MemoryStore;
import org.openrdf.sail.SailConnection;
import org.openrdf.sail.SailException;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.model.Statement;
import info.aduna.iteration.CloseableIteration;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameGraphTest extends TestCase {

    public static MemoryStore loadMemoryStore(String tripleFile, RDFFormat tripleFileFormat) throws Exception {
        MemoryStore sail = new MemoryStore();
        sail.initialize();
        Repository repo = new SailRepository(sail);
        RepositoryConnection connection = repo.getConnection();
        connection.add(SesameGraph.class.getResourceAsStream(tripleFile), new String(), tripleFileFormat, new URIImpl("http://tinkerpop.com#graph"));
        connection.commit();
        connection.close();
        return sail;
    }

    public void testGraphExample1() throws Exception {
        MemoryStore sail = loadMemoryStore("graph-example-1.ntriple", RDFFormat.NTRIPLES);
        SailConnection sc = sail.getConnection();
        CloseableIteration<? extends Statement, SailException> results = sc.getStatements(null,null,null,false);
        assertEquals(6, countStatements(results, true));
        sail.shutDown();
    }

    public static int countStatements(CloseableIteration<? extends Statement, SailException> itty, boolean print) throws SailException {
        int counter = 0;
        while(itty.hasNext()) {
            Statement s = itty.next();
            if(print)
                System.out.println(s);
            counter++;
        }
        itty.close();
        return counter;
    }
}
