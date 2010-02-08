package com.tinkerpop.gremlin.functions.g;

import com.tinkerpop.gremlin.functions.FunctionLibrary;
import com.tinkerpop.gremlin.functions.g.flow.ContinueFunction;
import com.tinkerpop.gremlin.functions.g.flow.HaltFunction;
import com.tinkerpop.gremlin.functions.g.graph.*;
import com.tinkerpop.gremlin.functions.g.lme.*;
import com.tinkerpop.gremlin.functions.g.number.ProbabilityFunction;
import com.tinkerpop.gremlin.functions.g.number.RandomNaturalFunction;
import com.tinkerpop.gremlin.functions.g.number.RandomRealFunction;
import com.tinkerpop.gremlin.functions.g.util.*;
import com.tinkerpop.gremlin.functions.g.var.AssignFunction;
import com.tinkerpop.gremlin.functions.g.var.UnassignFunction;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinFunctions extends FunctionLibrary {

    public static final String NAMESPACE_PREFIX = "g";

    public GremlinFunctions() {
        // variables
        this.addFunction(NAMESPACE_PREFIX, new AssignFunction());
        this.addFunction(NAMESPACE_PREFIX, new UnassignFunction());
        // graphs
        this.addFunction(NAMESPACE_PREFIX, new IdFunction());
        this.addFunction(NAMESPACE_PREFIX, new KeyFunction());
        this.addFunction(NAMESPACE_PREFIX, new LoadFunction());
        this.addFunction(NAMESPACE_PREFIX, new SaveFunction());
        this.addFunction(NAMESPACE_PREFIX, new AddVertexFunction());
        this.addFunction(NAMESPACE_PREFIX, new AddEdgeFunction());
        this.addFunction(NAMESPACE_PREFIX, new RemoveVertexEdgeFunction());
        this.addFunction(NAMESPACE_PREFIX, new AddIndexFunction());
        this.addFunction(NAMESPACE_PREFIX, new IndexAllFunction());
        this.addFunction(NAMESPACE_PREFIX, new RemoveIndexFunction());
        this.addFunction(NAMESPACE_PREFIX, new ClearFunction());
        this.addFunction(NAMESPACE_PREFIX, new CloseFunction());
        // lists
        this.addFunction(NAMESPACE_PREFIX, new ListFunction());
        this.addFunction(NAMESPACE_PREFIX, new RemoveFunction());
        this.addFunction(NAMESPACE_PREFIX, new DeduplicateFunction());
        this.addFunction(NAMESPACE_PREFIX, new UnionFunction());
        this.addFunction(NAMESPACE_PREFIX, new IntersectFunction());
        this.addFunction(NAMESPACE_PREFIX, new DifferenceFunction());
        this.addFunction(NAMESPACE_PREFIX, new RetainFunction());
        this.addFunction(NAMESPACE_PREFIX, new ExceptFunction());
        // maps and elements
        this.addFunction(NAMESPACE_PREFIX, new MapFunction());
        this.addFunction(NAMESPACE_PREFIX, new KeysFunction());
        this.addFunction(NAMESPACE_PREFIX, new ValuesFunction());
        // lists and maps and elements
        this.addFunction(NAMESPACE_PREFIX, new GetFunction());
        this.addFunction(NAMESPACE_PREFIX, new SortFunction());
        this.addFunction(NAMESPACE_PREFIX, new OperateValueFunction());
        // numbers
        this.addFunction(NAMESPACE_PREFIX, new ProbabilityFunction());
        this.addFunction(NAMESPACE_PREFIX, new RandomRealFunction());
        this.addFunction(NAMESPACE_PREFIX, new RandomNaturalFunction());
        // flow control
        this.addFunction(NAMESPACE_PREFIX, new HaltFunction());
        this.addFunction(NAMESPACE_PREFIX, new ContinueFunction());
        // utilities
        this.addFunction(NAMESPACE_PREFIX, new TypeFunction());
        this.addFunction(NAMESPACE_PREFIX, new PrintFunction());
        this.addFunction(NAMESPACE_PREFIX, new TimeFunction());
        this.addFunction(NAMESPACE_PREFIX, new PathFunction());
        this.addFunction(NAMESPACE_PREFIX, new ToJsonFunction());
        this.addFunction(NAMESPACE_PREFIX, new FromJsonFunction());
    }

}
