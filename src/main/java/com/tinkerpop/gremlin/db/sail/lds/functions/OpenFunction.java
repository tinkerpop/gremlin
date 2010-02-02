package com.tinkerpop.gremlin.db.sail.lds.functions;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.db.sail.SailFunctions;
import com.tinkerpop.gremlin.db.sail.SailGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import net.fortytwo.linkeddata.sail.LinkedDataSail;
import net.fortytwo.ripple.Ripple;
import net.fortytwo.ripple.URIMap;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.openrdf.sail.Sail;
import org.openrdf.sail.memory.MemoryStore;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OpenFunction implements Function {

    public static final String FUNCTION_NAME = "open";

    public Graph invoke(final ExpressionContext context, final Object[] parameters) {

        if (null == parameters) {
            try {
                Ripple.initialize();
                Sail baseSail = new MemoryStore();
                baseSail.initialize();
                URIMap uriMap = new URIMap();
                Sail sail = new LinkedDataSail(baseSail, uriMap);
                return new SailGraph(sail);
            } catch (Exception e) {
                throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());

            }
        } else if (parameters.length == 1) {
            Object object = FunctionHelper.nodeSetConversion(parameters[0]);
            if (object instanceof SailGraph) {
                try {
                    Ripple.initialize();
                    URIMap uriMap = new URIMap();
                    Sail sail = new LinkedDataSail(((SailGraph) object).getSail(), uriMap);
                    return new SailGraph(sail);
                } catch (Exception e) {
                    throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());

                }
            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SailFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
