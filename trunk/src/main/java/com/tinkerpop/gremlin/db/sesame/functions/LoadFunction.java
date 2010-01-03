package com.tinkerpop.gremlin.db.sesame.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.db.sesame.SesameTokens;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class LoadFunction implements Function {

    public static final String FUNCTION_NAME = "load";

    public Boolean invoke(ExpressionContext context, Object[] parameters) {

        if (null != parameters && parameters.length > 2) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof SesameGraph && objects.length == 3) {
                if (objects[1] instanceof String && objects[2] instanceof String) {
                    insertRDF((SesameGraph) objects[0], (String) objects[1], (String) objects[2], null);
                    return Boolean.TRUE;
                }
            } else if (objects[0] instanceof SesameGraph && objects.length == 4) {
                if (objects[0] instanceof SesameGraph && objects[1] instanceof String && objects[2] instanceof String && objects[3] instanceof String) {
                    insertRDF((SesameGraph) objects[0], (String) objects[1], (String) objects[2], (String) objects[3]);
                    return Boolean.TRUE;
                }
            } else if (objects.length == 3) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SesameGraph && objects[0] instanceof String && objects[1] instanceof String) {
                    insertRDF((SesameGraph) graph, (String) objects[0], (String) objects[1], null);
                    return Boolean.TRUE;
                }
            } else if (objects.length == 4) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SesameGraph && objects[0] instanceof String && objects[1] instanceof String && objects[2] instanceof String) {
                    insertRDF((SesameGraph) graph, (String) objects[0], (String) objects[1], (String) objects[2]);
                    return Boolean.TRUE;
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

    private static void insertRDF(SesameGraph graph, String file, String format, String baseGraph) throws EvaluationException {
        Repository repo = new SailRepository(graph.getSail());
        try {

            RepositoryConnection connection = repo.getConnection();
            if (null != baseGraph)
                connection.add(new File(file), null, SesameTokens.getFormat(format), new URIImpl(baseGraph));
            else
                connection.add(new File(file), null, SesameTokens.getFormat(format));

            connection.commit();
            connection.close();
        } catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }
    }

}
