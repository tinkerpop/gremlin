package com.tinkerpop.gremlin.compiler.functions.tg;

import com.tinkerpop.gremlin.compiler.functions.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class TinkerGraphFunctionLibrary {

    public static List<Function> library() {
        List<Function> functions = new ArrayList<Function>();

        functions.add(new OpenFunction());

        return functions;
    }

}
