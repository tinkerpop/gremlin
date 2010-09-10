package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.util.Tokens;

/**
 * @author Pavel A. Yaskevich
 */
public class RootVar extends Var {

    public RootVar(final GremlinScriptContext context) {
        super(Tokens.ROOT_VARIABLE, context);
    }

}
