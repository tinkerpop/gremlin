package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.types.Atom;
import com.tinkerpop.pipes.AbstractPipe;
import com.tinkerpop.pipes.filter.FilterPipe;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * [g:func()]
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class FunctionFilterPipe<S> extends AbstractPipe<S, S> implements FilterPipe<S> {

    private final Function function;
    private final List<Operation> parameters;
    private final List<Integer> pipeObjectIndices;
    private final GremlinScriptContext context;

    public FunctionFilterPipe(Function function, List<Operation> parameters, List<Integer> pipeObjectIndices, final GremlinScriptContext context) {
        this.function = function;
        this.parameters = parameters;
        this.pipeObjectIndices = pipeObjectIndices;
        this.context = context;
    }

    public S processNextStart() {
        while (true) {
            S s = this.starts.next();
            if (null != pipeObjectIndices) {
                for (Integer index : this.pipeObjectIndices)
                    this.parameters.set(index, new UnaryOperation(new Atom<S>(s)));
            }
            Object functionReturn = this.function.compute(this.parameters, this.context).getValue();
            if (functionReturn instanceof Boolean && ((Boolean) functionReturn)) {
                return s;
            }
        }
    }
}
