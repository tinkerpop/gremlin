package com.tinkerpop.gremlin.compiler.functions.g;

import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.functions.g.graph.IdFunction;
import com.tinkerpop.gremlin.compiler.functions.g.graph.LoadFunction;
import com.tinkerpop.gremlin.compiler.functions.g.io.ConcatFunction;
import com.tinkerpop.gremlin.compiler.functions.g.io.PrintFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.ListFunction;
import com.tinkerpop.gremlin.compiler.functions.g.lme.MapFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.CountFunction;
import com.tinkerpop.gremlin.compiler.functions.g.util.TimeFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GremlinFunctionLibrary {

    public static List<Function> library() {
        List<Function> functions = new ArrayList<Function>();

        // io
        functions.add(new PrintFunction());
        functions.add(new ConcatFunction());

        // graph
        functions.add(new LoadFunction());
        functions.add(new IdFunction());

        // util
        functions.add(new CountFunction());
        functions.add(new TimeFunction());

        // list
        functions.add(new ListFunction());

        // map
        functions.add(new MapFunction());

        return functions;
    }
}
