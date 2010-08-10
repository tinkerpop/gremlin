package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinObjectFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private Object leftHandSide;
    private Object rightHandSide;
    private GremlinScriptContext context;


    public GremlinObjectFilterPipe(final GremlinScriptContext context) {
        this.context = context;
    }

    public void setLeftHandSide(Object object) {
        this.leftHandSide = object;
    }

    public void setRightHandSide(Object object) {
        this.rightHandSide = object;
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            if (leftHandSide == rightHandSide)
                return s;
        }
    }
}
