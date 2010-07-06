package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public interface Function<T> {

    public Atom<T> compute(List<Operation> parameters) throws RuntimeException;

    public String getFunctionName();

}
