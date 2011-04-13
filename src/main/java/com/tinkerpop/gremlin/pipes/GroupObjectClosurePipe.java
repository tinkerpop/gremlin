package com.tinkerpop.gremlin.pipes;

import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.sideeffect.SideEffectPipe;
import groovy.lang.Closure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GroupObjectClosurePipe<S, T> extends AbstractPipe<S, S> implements SideEffectPipe<S, S, Map<S, T>> {

    private Map<S, T> objectMap;
    private final Closure closure;

    public GroupObjectClosurePipe(final Map<S, T> objectMap, final Closure closure) {
        this.objectMap = objectMap;
        this.closure = closure;
    }

    public GroupObjectClosurePipe(final Closure closure) {
        this(new HashMap<S, T>(), closure);
    }

    protected S processNextStart() {
        final S s = this.starts.next();
        final T t = this.objectMap.get(s);
        this.objectMap.put(s, (T) this.closure.call(new Object[]{t, s}));
        return s;
    }

    public Map<S, T> getSideEffect() {
        return this.objectMap;
    }

    public void reset() {
        try {
            this.objectMap = this.objectMap.getClass().getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        super.reset();
    }
}

