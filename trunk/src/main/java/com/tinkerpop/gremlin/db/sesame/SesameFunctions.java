package com.tinkerpop.gremlin.db.sesame;

import org.apache.commons.jxpath.ExpressionContext;
import org.openrdf.sail.nativerdf.NativeStore;
import org.openrdf.sail.SailException;
import org.openrdf.sail.memory.MemoryStore;

import java.io.File;

import com.tinkerpop.gremlin.model.Graph;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class SesameFunctions {

    public static final String NAMESPACE_PREFIX = "sail";

    public static SesameGraph open_ns(String directory) throws SailException {
        NativeStore sail = new NativeStore(new File(directory));
        sail.initialize();
        return new SesameGraph(sail);
    }

    public static SesameGraph open_ms() throws SailException {
        MemoryStore sail = new MemoryStore();
        sail.initialize();
        return new SesameGraph(sail);
    }

    public static Object close_ns(ExpressionContext context, String variableName) {
        ((Graph)context.getJXPathContext().getVariables().getVariable(variableName)).shutdown();
        return Boolean.TRUE;
    }

}
