package com.tinkerpop.gremlin.db.sesame;

import com.tinkerpop.gremlin.model.Graph;
import org.apache.commons.jxpath.ExpressionContext;
import org.openrdf.sail.SailException;
import org.openrdf.sail.memory.MemoryStore;
import org.openrdf.sail.nativerdf.NativeStore;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameFunctions {

    public static final String NAMESPACE_PREFIX = "sail";

    public static SesameGraph open_native(String directory) throws SailException {
        NativeStore sail = new NativeStore(new File(directory));
        sail.initialize();
        return new SesameGraph(sail);
    }

    public static SesameGraph open_memory() throws SailException {
        MemoryStore sail = new MemoryStore();
        sail.initialize();
        return new SesameGraph(sail);
    }

    public static Boolean register_ns(SesameGraph graph, String prefix, String namespace) throws SailException {
        graph.registerNamespace(prefix, namespace);
        return Boolean.TRUE;
    }

    public static Boolean close(SesameGraph graph) {
        graph.shutdown();
        return Boolean.TRUE;
    }

}
