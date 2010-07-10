package com.tinkerpop.gremlin.compiler.functions.sail;

import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.functions.FunctionHelper;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import info.aduna.iteration.CloseableIteration;
import org.openrdf.query.Binding;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.impl.MapBindingSet;
import org.openrdf.query.parser.ParsedQuery;
import org.openrdf.query.parser.sparql.SPARQLParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class SparqlFunction extends AbstractFunction<List<Map<String, Vertex>>> {

    private final String FUNCTION_NAME = "sparql";
    private static final String PREFIX_SPACE = "PREFIX ";
    private static final String COLON_LESSTHAN = ": <";
    private static final String GREATERTHAN_NEWLINE = ">\n";

    public Atom<List<Map<String, Vertex>>> compute(List<Operation> parameters) throws RuntimeException {

        final int size = parameters.size();
        final SailGraph graph = (SailGraph) FunctionHelper.getGraph(parameters, 0);

        final String sparqlQuery;

        if (size == 1) {
            sparqlQuery = (String) parameters.get(0).compute().getValue();
        } else if (size == 2) {
            sparqlQuery = (String) parameters.get(1).compute().getValue();
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        }

        return new Atom<List<Map<String, Vertex>>>(executeSparql(graph, sparqlQuery));
    }


    private static String getPrefixes(final SailGraph graph) {
        String prefixString = "";
        Map<String, String> namespaces = graph.getNamespaces();
        for (Map.Entry<String, String> entry : namespaces.entrySet()) {
            prefixString = prefixString + PREFIX_SPACE + entry.getKey() + COLON_LESSTHAN + entry.getValue() + GREATERTHAN_NEWLINE;
        }
        return prefixString;
    }

    private static List<Map<String, Vertex>> executeSparql(final SailGraph graph, String sparqlQuery) throws RuntimeException {
        try {
            sparqlQuery = getPrefixes(graph) + sparqlQuery;
            final SPARQLParser parser = new SPARQLParser();
            final ParsedQuery query = parser.parseQuery(sparqlQuery, null);
            boolean includeInferred = false;
            final CloseableIteration<? extends BindingSet, QueryEvaluationException> results = graph.getSailConnection().evaluate(query.getTupleExpr(), query.getDataset(), new MapBindingSet(), includeInferred);
            final List<Map<String, Vertex>> returnList = new ArrayList<Map<String, Vertex>>();
            try {
                while (results.hasNext()) {
                    BindingSet bs = results.next();
                    Map<String, Vertex> returnMap = new HashMap<String, Vertex>();
                    for (Binding b : bs) {
                        returnMap.put(b.getName(), graph.getVertex(b.getValue().toString()));
                    }
                    returnList.add(returnMap);
                }
            } finally {
                results.close();
            }
            return returnList;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public String getFunctionName() {
        return this.FUNCTION_NAME;
    }
}
