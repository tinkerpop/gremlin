package com.tinkerpop.gremlin;

import com.tinkerpop.gremlin.functions.FunctionLibrary;
import com.tinkerpop.gremlin.functions.Functions;
import com.tinkerpop.gremlin.functions.fs.FileSystemFunctions;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.functions.jung.JungFunctions;
import com.tinkerpop.gremlin.functions.lds.LinkedDataSailFunctions;
import com.tinkerpop.gremlin.functions.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.functions.sail.SailFunctions;
import com.tinkerpop.gremlin.functions.tg.TinkerFunctions;
import com.tinkerpop.gremlin.functions.xpath.XPathFunctions;
import com.tinkerpop.gremlin.models.pgm.Edge;
import com.tinkerpop.gremlin.models.pgm.Graph;
import com.tinkerpop.gremlin.models.pgm.Vertex;
import com.tinkerpop.gremlin.models.pgm.paths.EdgePropertyHandler;
import com.tinkerpop.gremlin.models.pgm.paths.GraphPropertyHandler;
import com.tinkerpop.gremlin.models.pgm.paths.VertexPropertyHandler;
import com.tinkerpop.gremlin.paths.MapPropertyHandler;
import com.tinkerpop.gremlin.paths.ObjectPropertyHandler;
import com.tinkerpop.gremlin.paths.PathLibrary;
import com.tinkerpop.gremlin.statements.Tokens;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinPathContext extends JXPathContextReferenceImpl {

    private static final Functions baseFunctions = new FunctionLibrary();

    private boolean newRoot = false;
    private FunctionLibrary functionLibrary = new FunctionLibrary();
    private static PathLibrary pathLibrary = new PathLibrary();
    private VariableLibrary variableLibrary = new VariableLibrary(this);

    static {
        baseFunctions.addFunctions(new XPathFunctions());
        baseFunctions.addFunctions(new GremlinFunctions());
        ///
        baseFunctions.addFunctions(new TinkerFunctions());
        baseFunctions.addFunctions(new Neo4jFunctions());
        baseFunctions.addFunctions(new SailFunctions());
        baseFunctions.addFunctions(new LinkedDataSailFunctions());
        baseFunctions.addFunctions(new FileSystemFunctions());
        baseFunctions.addFunctions(new JungFunctions());

        JXPathIntrospector.registerDynamicClass(Map.class, MapPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Graph.class, GraphPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Vertex.class, VertexPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Edge.class, EdgePropertyHandler.class);
        // todo: generalize this solution
        //JXPathIntrospector.registerDynamicClass(Float.class, ObjectPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(String.class, ObjectPropertyHandler.class);
        JXPathIntrospector.registerDynamicClass(Boolean.class, ObjectPropertyHandler.class);
    }

    public GremlinPathContext(final GremlinPathContext parentContext, final Object root) {
        super(parentContext, root);
        if (null == parentContext) {
            this.functionLibrary.addFunctions(baseFunctions);
            //this.setFunctions(this.functionLibrary);
            this.setVariables(new VariableLibrary(this));
        } else {
            this.getFunctions().addFunctions(parentContext.getFunctions());
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
        return this.functionLibrary;
    }
}
