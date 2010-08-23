package com.tinkerpop.gremlin.compiler.operations.util;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.pipes.GremlinPropertyPipe;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.gremlin.compiler.types.DynamicEntity;
import com.tinkerpop.gremlin.compiler.types.GPath;
import com.tinkerpop.gremlin.compiler.types.Var;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class DeclareVariable implements Operation {

    private final Atom<Object> object;
    private final Operation valueOperation;
    private final GremlinScriptContext context;

    private final String UNSUPPORTED_ARGUMENT = "Unsupported first argument, can only be variable or gpath ending with property e.g. ./outE/inV/@name.";
    
    public DeclareVariable(final Atom<Object> object, final Operation valueOp, final GremlinScriptContext context) {
        this.object = object;
        this.valueOperation = valueOp;
        this.context = context;
    }

    public Atom compute() {
        final Atom atom = this.valueOperation.compute();
        final Atom value = (!(atom instanceof DynamicEntity)) ? atom : dynamicValue(atom);

        if (this.object instanceof Var) {
            String name = ((Var) this.object).getVariableName();
            this.context.getVariableLibrary().declare(name, value);
        } else if (this.object instanceof GPath) {
            GPath path = (GPath) this.object;
            List<Pipe> pipes = path.getPipes();

            int size = pipes.size() - 1;
            Pipe lastPipe = pipes.get(size);

            Object subPathValue;
            
            if (size == 0) {
                subPathValue = path.getRoot().getValue();
            } else {
                final List<Pipe> subPipes = pipes.subList(0, size);
                final GPath subPath = new GPath(path.getRoot(), subPipes, context);
                subPathValue = subPath.getValue();
            }

            if (lastPipe instanceof GremlinPropertyPipe) {
                final GremlinPropertyPipe propertyPipe = (GremlinPropertyPipe) lastPipe;
                final Object key = propertyPipe.getPropertyKey();

                if (subPathValue instanceof Iterable) {
                    final Iterable results = (Iterable) subPathValue;

                    if (value.isIterable()) {
                        Iterator resultsIterator = results.iterator();

                        for (Object v : (Iterable) value.getValue()) {
                            setObjectProperty(resultsIterator.next(), key, v);
                        }
                    } else {
                        final Object object = results.iterator().next();
                        setObjectProperty(object, key, value.getValue());
                    }

                    return new Atom<Iterator>(pipelineWithSinglePipe(results, lastPipe));
                } else {
                    setObjectProperty(subPathValue, key, value.getValue());
                }
            } else {
                throw new RuntimeException(UNSUPPORTED_ARGUMENT);
            }
        } else {
            throw new RuntimeException(UNSUPPORTED_ARGUMENT);
        }

        return value;
    }

    public Type getType() {
        return Type.STATEMENT;
    }

    private Atom dynamicValue(final Atom atom) {
        if (atom instanceof Var) {
            final Var variable = (Var) atom;
            if (variable.getVariableName().equals(Tokens.IDENTITY)) {
                return new Atom<Object>(this.context.getCurrentPoint());
            }
        }

        return new Atom<Object>(atom.getValue());
    }

    private void setObjectProperty(final Object object, final Object key, final Object value) {
        if (object instanceof Element) {
            Element element = (Element) object;
            element.setProperty((String) key, value);
        } else if (object instanceof Map) {
            Map map = (Map) object;
            map.put(key, value);
        }
    }

    private Pipeline pipelineWithSinglePipe(final Iterable root, final Pipe pipe) {
        Pipeline pipeline = new Pipeline(Arrays.asList(pipe));
        pipeline.setStarts(root);
        return pipeline;
    }
}
