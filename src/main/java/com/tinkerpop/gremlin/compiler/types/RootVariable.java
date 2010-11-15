package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.util.Tokens;

/**
 * @author Pavel A. Yaskevich
 */
public class RootVariable extends Variable {

    public RootVariable(final GremlinScriptContext context) {
        super(Tokens.ROOT_VARIABLE, context);
    }

}
