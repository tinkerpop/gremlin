package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import groovy.lang.Closure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupCountClosurePipe<S> extends AbstractPipe<S, S> implements SideEffectPipe<S, S, Map<S, Number>> {

    private final Map<S, Number> countMap;
    private final Closure closure;

    public GroupCountClosurePipe(final Map<S, Number> countMap, final Closure closure) {
        this.countMap = countMap;
        this.closure = closure;
    }

    public GroupCountClosurePipe(final Closure closure) {
        this(new HashMap<S, Number>(), closure);
    }

    protected S processNextStart() {
        final S s = this.starts.next();
        final Number number = this.countMap.get(s);
        if (null == number)
            this.countMap.put(s, (Number) this.closure.call(0));
        else
            this.countMap.put(s, (Number) this.closure.call(number));
        return s;
    }

    public Map<S, Number> getSideEffect() {
        return this.countMap;
    }

    public void reset() {
        this.countMap.clear();
        super.reset();
    }
}
