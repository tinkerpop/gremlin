package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.fs.FileSystemFunctions;
import com.tinkerpop.gremlin.db.mongo.MongoFunctions;
import com.tinkerpop.gremlin.db.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.db.sail.SailFunctions;
import com.tinkerpop.gremlin.db.sail.lds.LinkedDataSailFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.functions.NativeFunction;
import com.tinkerpop.gremlin.functions.NativeFunctionLibrary;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.paths.Path;
import com.tinkerpop.gremlin.paths.PathLibrary;
import com.tinkerpop.gremlin.statements.EvaluationException;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;
    private static final Pattern variablePattern = Pattern.compile(Tokens.VARIABLE_REGEX);
    private static FunctionLibrary functionLibrary;
    private static PathLibrary pathLibrary;

    static {
        functionLibrary = new FunctionLibrary();
        pathLibrary = new PathLibrary();

        JXPathIntrospector.registerDynamicClass(Graph.class, GraphPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);

        functionLibrary.addFunctions(new CoreFunctions());
        functionLibrary.addFunctions(new GremlinFunctions());
        ///
        functionLibrary.addFunctions(new TinkerFunctions());
        functionLibrary.addFunctions(new Neo4jFunctions());
        functionLibrary.addFunctions(new SailFunctions());
        functionLibrary.addFunctions(new LinkedDataSailFunctions());
        functionLibrary.addFunctions(new MongoFunctions());
        functionLibrary.addFunctions(new FileSystemFunctions());
    }

    public GremlinPathContext(final GremlinPathContext parentContext, final Object root) {
        super(parentContext, root);
        if (null == parentContext) {
            this.setFunctions(functionLibrary);
        } else {
            // TODO: Why is this needed? Completely odd...
            if (parentContext.hasVariable(Tokens.GRAPH_VARIABLE))
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

    public static void registerNativeFunction(final NativeFunction nativeFunction) {
        functionLibrary.addFunctions(new NativeFunctionLibrary(nativeFunction));
    }

    //Todo:integrate native and java functions
    public void addFunctions(Functions functions) {
        functionLibrary.addFunctions(functions);
    }

    public static void addPath(Path path) {
        GremlinPathContext.pathLibrary.addPath(path);
    }

    public static Path getPath(String name) {
        return GremlinPathContext.pathLibrary.getPath(name);
    }

    public static Set<String> getPathNames() {
        return GremlinPathContext.pathLibrary.getPathNames();
    }
}
