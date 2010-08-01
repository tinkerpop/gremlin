package com.tinkerpop.gremlin.compiler.functions.sail.neo4jsail;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.index.IndexService;
import org.neo4j.index.lucene.LuceneIndexService;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.rdf.sail.GraphDatabaseSail;
import org.neo4j.rdf.store.RdfStore;
import org.neo4j.rdf.store.VerboseQuadStore;

import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction extends AbstractFunction<Graph> {

    private final String FUNCTION_NAME = "open";

    public Atom<Graph> compute(List<Operation> parameters, final GremlinScriptContext context) throws RuntimeException {

        final int size = parameters.size();
        final String directory;
        if (size == 1) {
            directory = (String) parameters.get(0).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        GraphDatabaseService graphDb = new EmbeddedGraphDatabase(directory);
        IndexService indexService = new LuceneIndexService(graphDb);
        RdfStore rdfStore = new VerboseQuadStore(graphDb, indexService);
        return new Atom<Graph>(new SailGraph(new GraphDatabaseSail(graphDb, rdfStore, true)));
    }

    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
