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
public class SparqlFunction extends AbstractFunction<List<Atom<Map<Atom<String>,Atom<Vertex>>>>> {

    private final String FUNCTION_NAME = "sparql";
    private static final String PREFIX_SPACE = "PREFIX ";
    private static final String COLON_LESSTHAN = ": <";
    private static final String GREATERTHAN_NEWLINE = ">\n";

    public Atom<List<Atom<Map<Atom<String>,Atom<Vertex>>>>> compute(List<Operation> parameters) throws RuntimeException {

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

        return new Atom<List<Atom<Map<Atom<String>,Atom<Vertex>>>>>(executeSparql(graph, sparqlQuery));
    }


    private static String getPrefixes(final SailGraph graph) {
        String prefixString = "";
        Map<String, String> namespaces = graph.getNamespaces();
        for (Map.Entry<String, String> entry : namespaces.entrySet()) {
            prefixString = prefixString + PREFIX_SPACE + entry.getKey() + COLON_LESSTHAN + entry.getValue() + GREATERTHAN_NEWLINE;
        }
        return prefixString;
    }

    private static List<Atom<Map<Atom<String>,Atom<Vertex>>>> executeSparql(final SailGraph graph, String sparqlQuery) throws RuntimeException {
        try {
            sparqlQuery = getPrefixes(graph) + sparqlQuery;
            SPARQLParser parser = new SPARQLParser();
            ParsedQuery query = parser.parseQuery(sparqlQuery, null);
            boolean includeInferred = false;
            CloseableIteration<? extends BindingSet, QueryEvaluationException> results = graph.getSailConnection().evaluate(query.getTupleExpr(), query.getDataset(), new MapBindingSet(), includeInferred);
            List<Atom<Map<Atom<String>, Atom<Vertex>>>> returnList = new ArrayList<Atom<Map<Atom<String>, Atom<Vertex>>>>();
            try {
                while (results.hasNext()) {
                    BindingSet bs = results.next();
                    Map<Atom<String>, Atom<Vertex>> returnMap = new HashMap<Atom<String>, Atom<Vertex>>();
                    for (Binding b : bs) {
                        returnMap.put(new Atom<String>(b.getName()), new Atom<Vertex>(graph.getVertex(b.getValue().toString())));
                    }
                    returnList.add(new Atom<Map<Atom<String>, Atom<Vertex>>>(returnMap));
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
