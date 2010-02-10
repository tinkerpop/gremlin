package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.functions.fs.FileSystemFunctions;
import com.tinkerpop.gremlin.functions.g.GremlinFunctions;
import com.tinkerpop.gremlin.functions.jung.JungFunctions;
import com.tinkerpop.gremlin.functions.lds.LinkedDataSailFunctions;
import com.tinkerpop.gremlin.functions.neo4j.Neo4jFunctions;
import com.tinkerpop.gremlin.functions.sail.SailFunctions;
import com.tinkerpop.gremlin.functions.tg.TinkerFunctions;
import com.tinkerpop.gremlin.functions.xpath.XPPathFunctions;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CoreFunctionLibrary {

    public static FunctionLibrary getBaseLibrary() {
        FunctionLibrary baseLibrary = new FunctionLibrary();
        baseLibrary.addFunctions(new XPPathFunctions());
        baseLibrary.addFunctions(new GremlinFunctions());
        ///
        baseLibrary.addFunctions(new TinkerFunctions());
        baseLibrary.addFunctions(new Neo4jFunctions());
        baseLibrary.addFunctions(new SailFunctions());
        baseLibrary.addFunctions(new LinkedDataSailFunctions());
        baseLibrary.addFunctions(new FileSystemFunctions());
        baseLibrary.addFunctions(new JungFunctions());
        return baseLibrary;
    }
}
