package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.mongo.MongoFunctions;
import com.tinkerpop.gremlin.db.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.db.sail.SailFunctions;
import com.tinkerpop.gremlin.db.sail.lds.LinkedDataSailFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;
    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);
    private static FunctionLibrary library;

    static {
        library = new FunctionLibrary();

        JXPathIntrospector.registerDynamicClass(Graph.class, GraphPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);

        library.addFunctions(new CoreFunctions());
        library.addFunctions(new GremlinFunctions());
        ///
        library.addFunctions(new TinkerFunctions());
        library.addFunctions(new Neo4jFunctions());
        library.addFunctions(new SailFunctions());
        library.addFunctions(new LinkedDataSailFunctions());
        library.addFunctions(new MongoFunctions());
    }

    public GremlinPathContext(final GremlinPathContext parentContext, final Object root) {
        super(parentContext, root);
        if (null == parentContext) {
            this.setFunctions(library);
        } else {
            // TODO: Why is this needed? Completely odd...
            if(parentContext.hasVariable(Tokens.GRAPH_VARIABLE))
                this.setVariable(Tokens.GRAPH_VARIABLE, parentContext.getVariable(Tokens.GRAPH_VARIABLE));
        }
    }

    public GremlinPathContext(final Object root) {
        this(null, root);
    }

    public static GremlinPathContext newContext(final GremlinPathContext parentContext, final Object root) {
        return new GremlinPathContext(parentContext, root);
    }

    public static GremlinPathContext newContext(final Object root) {
        return GremlinPathContext.newContext(null, root);
    }

    public void setRoot(Object root) {
        if (null != root && root instanceof List) {
            List rootList = (List) root;
            if (rootList.size() == 1)
                root = rootList.get(0);
        }
        this.contextBean = root;
        this.newRoot = true;
    }

    public Object getRoot() {
        return this.contextBean;
    }

    public boolean rootChanged() {
        return this.newRoot;
    }

    public void setVariable(final String variable, final Object value) {

        if (variablePattern.matcher(variable).matches()) {
            // $i := ././././
            if (variable.equals(Tokens.AT_VARIABLE)) {
                // $_ := ./././
                this.setRoot(value);
            } else if (variable.equals(Tokens.GRAPH_VARIABLE)) {
                // $_g := ./././
                if (!(value instanceof Graph)) {
                    throw new EvaluationException(Tokens.GRAPH_VARIABLE + " can only reference a graph");
                }
            }
            this.getVariables().declareVariable(GremlinPathContext.removeVariableDollarSign(variable), value);
        } else {
            // $i[1] := ././././
            // $i/@key := ././././
            if (!(value instanceof List)) { //|| (value instanceof Map) {
                this.setValue(variable, value);
            } else {
                if (((List) value).size() == 0) {
                    this.setValue(variable, null);
                } else {
                    throw EvaluationException.createException(EvaluationException.EvaluationErrorType.EMBEDDED_COLLECTIONS);
                }
            }
        }
    }

    public boolean hasVariable(final String variable) {
        return this.getVariables().isDeclaredVariable(GremlinPathContext.removeVariableDollarSign(variable));
    }

    public Object getVariable(final String variable) {
        try {
            return this.getVariables().getVariable(GremlinPathContext.removeVariableDollarSign(variable));
        } catch (Exception e) {
            return null;
        }
    }

    public void removeVariable(final String variable) {
        // TODO fix this hack
        this.getVariables().declareVariable(GremlinPathContext.removeVariableDollarSign(variable), null);
        this.getVariables().undeclareVariable(GremlinPathContext.removeVariableDollarSign(variable));

    }

    private static String removeVariableDollarSign(final String variable) {
        return variable.replace(Tokens.DOLLAR_SIGN, Tokens.EMPTY_STRING);
    }

    public static void registerFunction(final DynamicFunction dynamicFunction) {
        library.addFunctions(new DynamicFunctions(dynamicFunction));
    }

    public static void registerPath(final DynamicPath dynamicPath) {
        ElementPropertyHandler.addDynamicPath(dynamicPath);
    }
}
