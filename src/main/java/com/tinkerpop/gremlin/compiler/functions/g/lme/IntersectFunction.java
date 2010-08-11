package com.tinkerpop.gremlin.compiler.functions.g.lme;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.pipes.PipeHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class IntersectFunction extends AbstractFunction<Iterable> {

    private static final String FUNCTION_NAME = "intersect";

    public Atom<Iterable> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {

        if (arguments.size() < 2) {
            throw new RuntimeException(this.createUnsupportedArgumentMessage());
        } else {
            Set set = null;
            for (Operation operation : arguments) {
                final Object object = operation.compute().getValue();
                if (object instanceof Iterable) {
                    if (null == set) {
                        set = new HashSet();
                        PipeHelper.fillCollection(((Iterable) object).iterator(), set);
                    } else {
                        Set temp = new HashSet();
                        PipeHelper.fillCollection(((Iterable) object).iterator(), temp);
                        set.retainAll(temp);
                    }
                } else {
                    if (null == set) {
                        set = new HashSet();
                        set.add(object);
                    } else {
                        set.retainAll(Arrays.asList(object));
                    }
                }
            }
            return new Atom<Iterable>(set);
        }
    }

    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}