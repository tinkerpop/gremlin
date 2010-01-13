package com.tinkerpop.gremlin.db.sail.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.sail.SailFunctions;
import com.tinkerpop.gremlin.db.sail.SailGraph;
import com.tinkerpop.gremlin.model.Graph;
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
import org.openrdf.sail.SailConnection;

import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
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
                SparqlFunction.executeSparql((SailGraph) objects[0], (String) objects[1]);
                return null;
            } else if (objects.length == 1) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SailGraph && objects[0] instanceof String) {
                    SparqlFunction.executeSparql((SailGraph) graph, (String) objects[0]);
                    return null;
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

    private static void executeSparql(final SailGraph graph, String sparqlQuery) {
        try {
            sparqlQuery = getPrefixes(graph) + sparqlQuery;
            System.out.println(sparqlQuery);
            SPARQLParser parser = new SPARQLParser();
            ParsedQuery query = parser.parseQuery(sparqlQuery, null);
            SailConnection sc = graph.getSailConnection();
            try {
                boolean includeInferred = false;
                CloseableIteration<? extends BindingSet, QueryEvaluationException> results = sc.evaluate(query.getTupleExpr(), query.getDataset(), new MapBindingSet(), includeInferred);
                try {
                    while (results.hasNext()) {
                        BindingSet bs = results.next();
                        System.out.println("------");
                        for (Binding b : bs) {
                            System.out.println(b.getName() + " " + b.getValue());
                        }
                    }
                } finally {
                    results.close();
                }
            } finally {
                sc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
