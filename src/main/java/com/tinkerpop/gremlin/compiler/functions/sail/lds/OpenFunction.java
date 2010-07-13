package com.tinkerpop.gremlin.compiler.functions.sail.lds;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import net.fortytwo.linkeddata.sail.LinkedDataSail;
import net.fortytwo.ripple.Ripple;
import net.fortytwo.ripple.URIMap;
import org.openrdf.sail.Sail;
import org.openrdf.sail.memory.MemoryStore;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction extends AbstractFunction<Graph> {

    private final String FUNCTION_NAME = "open";

    public Atom<Graph> compute(final List<Operation> parameters) throws RuntimeException {

        final int size = parameters.size();
        if (size == 0) {
            try {
                Ripple.initialize();
                final Sail baseSail = new MemoryStore();
                baseSail.initialize();
                final URIMap uriMap = new URIMap();
                final Sail sail = new LinkedDataSail(baseSail, uriMap);
                return new Atom<Graph>(new SailGraph(sail));
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());

            }
        } else if (size == 1) {
            try {
                Ripple.initialize();
                final URIMap uriMap = new URIMap();
                final Sail sail = new LinkedDataSail(((SailGraph) parameters.get(0).compute().getValue()).getSail(), uriMap);
                return new Atom<Graph>(new SailGraph(sail));
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
