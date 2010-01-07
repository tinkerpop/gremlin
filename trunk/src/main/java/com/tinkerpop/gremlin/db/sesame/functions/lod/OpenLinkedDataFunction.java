package com.tinkerpop.gremlin.db.sesame.functions.lod;

import com.tinkerpop.gremlin.FunctionHelper;
import com.tinkerpop.gremlin.GremlinFunctions;
import com.tinkerpop.gremlin.db.sesame.SesameFunctions;
import com.tinkerpop.gremlin.db.sesame.SesameGraph;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.statements.EvaluationException;
import org.apache.commons.jxpath.ExpressionContext;
import org.apache.commons.jxpath.Function;
import org.openrdf.sail.Sail;
import org.openrdf.sail.memory.MemoryStore;
import net.fortytwo.ripple.Ripple;
import net.fortytwo.ripple.URIMap;
import net.fortytwo.linkeddata.sail.LinkedDataSail;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public class OpenLinkedDataFunction implements Function {

    public static final String FUNCTION_NAME = "open-lod";

    public Graph invoke(ExpressionContext context, Object[] parameters) {

        if (null == parameters) {
            try {
                Ripple.initialize();
                Sail baseSail = new MemoryStore();
                baseSail.initialize();
                URIMap uriMap = new URIMap();
                Sail sail = new LinkedDataSail(baseSail, uriMap);
                //sail.initialize();
                return new SesameGraph(sail);
            } catch (Exception e) {
                throw new EvaluationException(GremlinFunctions.NAMESPACE_PREFIX + ":" + FUNCTION_NAME + " " + e.getMessage());

            }
        }
        throw EvaluationException.createException(FunctionHelper.makeFunctionName(SesameFunctions.NAMESPACE_PREFIX, FUNCTION_NAME), EvaluationException.EvaluationErrorType.UNSUPPORTED_PARAMETERS);

    }
}
