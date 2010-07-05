package com.tinkerpop.gremlin.compiler.functions;

import com.tinkerpop.gremlin.compiler.Atom;
import com.tinkerpop.gremlin.compiler.operations.Operation;

import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public interface Function {

    public final String UNSUPPORTED_ARGUMENTS = "Unsupported arguments for ";

    public Atom compute(final List<Operation> params) throws RuntimeException;

    public String getFunctionName();

}
