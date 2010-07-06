package com.tinkerpop.gremlin.compiler.functions.g;

import com.tinkerpop.gremlin.compiler.functions.AbstractFunctions;
import com.tinkerpop.gremlin.compiler.functions.g.graph.IdFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.KeyFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.LoadFunction;
import com.tinkerpop.gremlin.compiler.functions.g.io.ConcatFunction;
import com.tinkerpop.gremlin.compiler.functions.g.io.PrintFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.DeduplicateFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.ListFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.MapFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.UnionFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.RandomRealFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.SumFunction;
import com.tinkerpop.gremlin.compiler.functions.g.number.CountFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.TimeFunction;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinFunctions extends AbstractFunctions {

    static {
        NAMESPACE = "g";
    }

    public GremlinFunctions() {
        // io
        functions.add(new PrintFunction());
        functions.add(new ConcatFunction());
        // graph
        functions.add(new LoadFunction());
        functions.add(new IdFunction());
        functions.add(new KeyFunction());
        // util
        functions.add(new CountFunction());
        functions.add(new TimeFunction());
        // list
        functions.add(new ListFunction());
        functions.add(new DeduplicateFunction());
        functions.add(new UnionFunction());
        // map
        functions.add(new MapFunction());
        // number
        functions.add(new RandomRealFunction());
        functions.add(new SumFunction());
    }


}
