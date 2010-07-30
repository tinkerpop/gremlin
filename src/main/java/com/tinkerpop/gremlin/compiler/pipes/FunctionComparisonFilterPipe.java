package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.pipes.filter.AbstractComparisonFilterPipe;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * [g:func() > 5]
 *
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionComparisonFilterPipe<S> extends AbstractComparisonFilterPipe<S, Object> {

    private final Function function;
    private final List<Operation> parameters;
    private final List<Integer> pipeObjectIndices;
    private final GremlinScriptContext context;
    
    public FunctionComparisonFilterPipe(Function function, List<Operation> parameters, List<Integer> pipeObjectIndices, Filter filter, Object objectProperty, final GremlinScriptContext context) {
        super(objectProperty, filter);
        this.function = function;
        this.parameters = parameters;
        this.pipeObjectIndices = pipeObjectIndices;
        this.context = context;
    }

    public S processNextStart() {
        while (this.starts.hasNext()) {
            S s = this.starts.next();
            if (null != this.pipeObjectIndices) {
                for (Integer index : this.pipeObjectIndices)
                    this.parameters.set(index, new UnaryOperation(new Atom<S>(s)));
            }
            Object functionReturn = this.function.compute(this.parameters, this.context).getValue();
            if (compareObjectProperty(functionReturn)) {
                return s;
            }
        }
        throw new NoSuchElementException();
    }
}
