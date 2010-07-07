package com.tinkerpop.gremlin.compiler.functions.g;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;
import com.tinkerpop.gremlin.compiler.functions.g.bool.BooleanFunction;
import com.tinkerpop.gremlin.compiler.functions.g.bool.NotFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.*;
import com.tinkerpop.gremlin.compiler.functions.g.io.PrintFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.*;
import com.tinkerpop.gremlin.compiler.functions.g.number.*;
import com.tinkerpop.gremlin.compiler.functions.g.string.*;
import com.tinkerpop.gremlin.compiler.functions.g.util.PathFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.TimeFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.TypeFunction;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "g";

    public GremlinFunctions() {
        // bool
        functions.add(new BooleanFunction());
        functions.add(new NotFunction());
        // graph
        functions.add(new ClearFunction());
        functions.add(new CloseFunction());
        functions.add(new LoadFunction());
        functions.add(new IdFunction());
        functions.add(new KeyFunction());
        functions.add(new SaveFunction());
        // io
        functions.add(new PrintFunction());
        // lme
        functions.add(new ListFunction());
        functions.add(new DeduplicateFunction());
        functions.add(new UnionFunction());
        functions.add(new ValuesFunction());
        functions.add(new MapFunction());
        // number
        functions.add(new CountFunction());
        functions.add(new DoubleFunction());
        functions.add(new FloatFunction());
        functions.add(new IntegerFunction());
        functions.add(new LongFunction());
        functions.add(new RandomNaturalFunction());
        functions.add(new RandomRealFunction());
        functions.add(new SumFunction());
        functions.add(new RoundFunction());
        // string
        functions.add(new ConcatFunction());
        functions.add(new ContainsFunction());
        functions.add(new StartsWithFunction());
        functions.add(new StringFunction());
        functions.add(new StringLengthFunction());
        // util
        functions.add(new PathFunction());
        functions.add(new TypeFunction());
        functions.add(new TimeFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }


}
