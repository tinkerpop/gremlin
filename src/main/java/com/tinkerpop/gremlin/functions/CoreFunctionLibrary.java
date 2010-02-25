package com.tinkerpop.gremlin.functions;

import com.tinkerpop.gremlin.functions.fs.FileSystemFunctionLibrary;
import com.tinkerpop.gremlin.functions.g.GremlinFunctionLibrary;
import com.tinkerpop.gremlin.functions.jung.JungFunctionLibrary;
import com.tinkerpop.gremlin.functions.lds.LinkedDataSailFunctionLibrary;
import com.tinkerpop.gremlin.functions.neo4j.Neo4jFunctionLibrary;
import com.tinkerpop.gremlin.functions.sail.SailFunctionLibrary;
import com.tinkerpop.gremlin.functions.tg.TinkerGraphFunctionLibrary;
import com.tinkerpop.gremlin.functions.xpath.XPathFunctionLibrary;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class CoreFunctionLibrary {

    public static FunctionLibrary getBaseLibrary() {
        FunctionLibrary baseLibrary = new FunctionLibrary();
        baseLibrary.addFunctions(new XPathFunctionLibrary());
        baseLibrary.addFunctions(new GremlinFunctionLibrary());
        ///
        baseLibrary.addFunctions(new TinkerGraphFunctionLibrary());
        baseLibrary.addFunctions(new Neo4jFunctionLibrary());
        baseLibrary.addFunctions(new SailFunctionLibrary());
        baseLibrary.addFunctions(new LinkedDataSailFunctionLibrary());
        baseLibrary.addFunctions(new FileSystemFunctionLibrary());
        baseLibrary.addFunctions(new JungFunctionLibrary());
        return baseLibrary;
    }
}
