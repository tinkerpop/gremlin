package com.tinkerpop.gremlin.compiler.pipes;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
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
    //private int counter = -1;

    public FunctionFilterPipe(Function function, List<Operation> parameters, List<Integer> pipeObjectIndices) {
        this.function = function;
        this.parameters = parameters;
        this.pipeObjectIndices = pipeObjectIndices;
    }

    public S processNextStart() {
        while (this.starts.hasNext()) {
            S s = this.starts.next();
            if (null != pipeObjectIndices) {
                for (Integer index : this.pipeObjectIndices)
                    this.parameters.set(index, new UnaryOperation(new Atom<S>(s)));
            }
            Object functionReturn = this.function.compute(this.parameters).getValue();
            if (functionReturn instanceof Boolean && ((Boolean) functionReturn)) {
                return s;
            }
        }
        throw new NoSuchElementException();
    }
}
