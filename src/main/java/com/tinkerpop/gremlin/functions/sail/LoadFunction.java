package com.tinkerpop.gremlin.functions.sail;

import com.tinkerpop.gremlin.functions.Function;
import com.tinkerpop.gremlin.functions.FunctionHelper;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailGraph;
import com.tinkerpop.gremlin.models.pgm.impls.sail.SailTokens;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;

import java.io.File;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class LoadFunction implements Function {

    public static final String FUNCTION_NAME = "load";

    public Boolean invoke(final ExpressionContext context, final Object[] parameters) {

        if (null != parameters && parameters.length > 1) {
            Object[] objects = FunctionHelper.nodeSetConversion(parameters);
            if (objects[0] instanceof SailGraph && objects.length == 3) {
                if (objects[1] instanceof String && objects[2] instanceof String) {
                    insertRDF((SailGraph) objects[0], (String) objects[1], (String) objects[2], null);
                    return Boolean.TRUE;
                }
            } else if (objects[0] instanceof SailGraph && objects.length == 4) {
                if (objects[0] instanceof SailGraph && objects[1] instanceof String && objects[2] instanceof String && objects[3] instanceof String) {
                    insertRDF((SailGraph) objects[0], (String) objects[1], (String) objects[2], (String) objects[3]);
                    return Boolean.TRUE;
                }
            } else if (objects.length == 2) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SailGraph && objects[0] instanceof String && objects[1] instanceof String) {
                    insertRDF((SailGraph) graph, (String) objects[0], (String) objects[1], null);
                    return Boolean.TRUE;
                }
            } else if (objects.length == 3) {
                Graph graph = FunctionHelper.getGraph(context);
                if (graph instanceof SailGraph && objects[0] instanceof String && objects[1] instanceof String && objects[2] instanceof String) {
                    insertRDF((SailGraph) graph, (String) objects[0], (String) objects[1], (String) objects[2]);
                    return Boolean.TRUE;
                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);
    }

    public String getName() {
        return FUNCTION_NAME;
    }

    private static void insertRDF(final SailGraph graph, final String file, final String format, final String baseGraph) throws EvaluationException {
        Repository repo = new SailRepository(graph.getSail());
        try {

            RepositoryConnection connection = repo.getConnection();
            if (null != baseGraph)
                connection.add(new File(file), null, SailTokens.getFormat(format), new URIImpl(baseGraph));
            else
                connection.add(new File(file), null, SailTokens.getFormat(format));

            connection.commit();
            connection.close();
        } catch (Exception e) {
            throw new EvaluationException(e.getMessage());
        }
    }

}
