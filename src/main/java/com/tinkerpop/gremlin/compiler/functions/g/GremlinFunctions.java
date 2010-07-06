package com.tinkerpop.gremlin.compiler.functions.g;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;
import com.tinkerpop.gremlin.compiler.functions.g.bool.NotFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.IdFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.KeyFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.LoadFunction;
import com.tinkerpop.gremlin.compiler.functions.g.io.PrintFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.DeduplicateFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.ListFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.MapFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.UnionFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.CountFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.RandomRealFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.RoundFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.SumFunction;
import com.tinkerpop.gremlin.compiler.functions.g.string.ConcatFunction;
import com.tinkerpop.gremlin.compiler.functions.g.string.ContainsFunction;
import com.tinkerpop.gremlin.compiler.functions.g.string.StartsWithFunction;
import com.tinkerpop.gremlin.compiler.functions.g.string.StringLengthFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.TimeFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.TypeFunction;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinFunctions extends AbstractFunctions {

    private static final String NAMESPACE = "g";

    public GremlinFunctions() {
        //bool
        functions.add(new NotFunction());
        // io
        functions.add(new PrintFunction());
        // string
        functions.add(new ConcatFunction());
        functions.add(new ContainsFunction());
        functions.add(new StartsWithFunction());
        functions.add(new StringLengthFunction());
        // graph
        functions.add(new LoadFunction());
        functions.add(new IdFunction());
        functions.add(new KeyFunction());
        // util
        functions.add(new TypeFunction());
        functions.add(new TimeFunction());
        // list
        functions.add(new ListFunction());
        functions.add(new DeduplicateFunction());
        functions.add(new UnionFunction());
        // map
        functions.add(new MapFunction());
        // number
        functions.add(new CountFunction());
        functions.add(new RandomRealFunction());
        functions.add(new SumFunction());
        functions.add(new RoundFunction());
    }

    public String getNamespace() {
        return NAMESPACE;
    }


}
