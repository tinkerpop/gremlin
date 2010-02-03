package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.db.fs.FileSystemFunctions;
import com.tinkerpop.gremlin.db.mongo.MongoFunctions;
import com.tinkerpop.gremlin.db.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.db.sail.SailFunctions;
import com.tinkerpop.gremlin.db.sail.lds.LinkedDataSailFunctions;
import com.tinkerpop.gremlin.db.tg.TinkerFunctions;
import com.tinkerpop.gremlin.functions.CoreFunctions;
import com.tinkerpop.gremlin.functions.GremlinFunctions;
import com.tinkerpop.gremlin.functions.NativeFunction;
import com.tinkerpop.gremlin.functions.NativeFunctions;
import com.tinkerpop.gremlin.model.Edge;
import com.tinkerpop.gremlin.model.Graph;
import com.tinkerpop.gremlin.model.Vertex;
import com.tinkerpop.gremlin.paths.PathLibrary;
import com.tinkerpop.gremlin.paths.handlers.*;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.FunctionLibrary;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private boolean newRoot = false;
    private static FunctionLibrary functionLibrary = new FunctionLibrary();
    private static PathLibrary pathLibrary = new PathLibrary();
    private VariableLibrary variableLibrary = new VariableLibrary(this);

    static {
        JXPathIntrospector.registerDynamicClass(Map.class, MapPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Graph.class, GraphPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
        // todo: generalize this solution
        //JXPathIntrospector.registerDynamicClass(Float.class, ObjectPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(String.class, ObjectPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Boolean.class, ObjectPropertyHandler.class);


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
            this.setVariables(new VariableLibrary(this));
        } else {
            // TODO: Why is this needed? Completely odd...
            if (parentContext.getVariables().isDeclaredVariable(Tokens.GRAPH_VARIABLE))
                this.getVariables().declareVariable(Tokens.GRAPH_VARIABLE, parentContext.getVariables().getVariable(Tokens.GRAPH_VARIABLE));
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

    public VariableLibrary getVariables() {
        return this.variableLibrary;
    }

    public static PathLibrary getPaths() {
        return pathLibrary;
    }

    public FunctionLibrary getFunctions() {
        return functionLibrary;
    }


    public static void registerNativeFunction(final NativeFunction nativeFunction) {
        functionLibrary.addFunctions(new NativeFunctions(nativeFunction));
    }

    //Todo:integrate native and java functions
    public void addFunctions(Functions functions) {
        functionLibrary.addFunctions(functions);
    }
}
