package com.tinkerpop.gremlin.models.ggm.impls.sail.functions;

import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.ggm.impls.sail.SailFunctions;
import com.tinkerpop.gremlin.models.ggm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.models.ggm.Graph;
import com.tinkerpop.gremlin.models.ggm.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import info.aduna.iteration.CloseableIteration;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
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
public class SparqlFunction implements Function {

    public static final String FUNCTION_NAME = "sparql";
    private static final String PREFIX_SPACE = "PREFIX ";
    private static final String COLON_LESSTHAN = ": <";
    private static final String GREATERTHAN_NEWLINE = ">\n";


    public Object invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects.length == 2 && FunctionHelper.assertTypes(objects, new Class[]{SailGraph.class, String.class})) {
                return SparqlFunction.executeSparql((SailGraph) objects[0], (String) objects[1]);
            } else if (objects.length == 1) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SailGraph && objects[0] instanceof String) {
                    return SparqlFunction.executeSparql((SailGraph) graph, (String) objects[0]);
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }


    private static String getPrefixes(final SailGraph graph) {
        String prefixString = "";
        Map<String, String> namespaces = graph.getNamespaces();
        for (Map.Entry<String, String> entry : namespaces.entrySet()) {
            prefixString = prefixString + PREFIX_SPACE + entry.getKey() + COLON_LESSTHAN + entry.getValue() + GREATERTHAN_NEWLINE;
        }
        return prefixString;
    }

    private static List<Map<String, Vertex>> executeSparql(final SailGraph graph, String sparqlQuery) {
        try {
            sparqlQuery = getPrefixes(graph) + sparqlQuery;
            SPARQLParser parser = new SPARQLParser();
            ParsedQuery query = parser.parseQuery(sparqlQuery, null);
            boolean includeInferred = false;
            CloseableIteration<? extends BindingSet, QueryEvaluationException> results = graph.getSailConnection().evaluate(query.getTupleExpr(), query.getDataset(), new MapBindingSet(), includeInferred);
            List<Map<String, Vertex>> returnList = new ArrayList<Map<String, Vertex>>();
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
            throw new EvaluationException(e.getMessage());
        }
    }
}
