package com.tinkerpop.gremlin.compiler.functions.g.ime;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.functions.AbstractFunction;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.operations.UnaryOperation;
import com.tinkerpop.gremlin.compiler.operations.math.*;
import com.tinkerpop.gremlin.compiler.types.Atom;

import java.util.List;
import java.util.Map;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class OperateValueFunction extends AbstractFunction<Number> {

    private static final String FUNCTION_NAME = "op-value";
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "div";
    private static final String MODULO = "mod";
    private static final String OPERATION_ERROR = "First argument must be +, -, *, div, or mod";

    public Atom<Number> compute(final List<Operation> arguments, final GremlinScriptContext context) throws RuntimeException {
        if (arguments.size() != 4)
            throw new RuntimeException(this.createUnsupportedArgumentMessage());

        final String operation = (String) arguments.get(0).compute().getValue();
        final Object struct = arguments.get(1).compute().getValue();
        final Object key = arguments.get(2).compute().getValue();
        final Number amount = (Number) arguments.get(3).compute().getValue();

        if (struct instanceof Map) {
            return new Atom<Number>(this.opValue(operation, (Map) struct, key, amount));
        } else if (struct instanceof Element) {
            return new Atom<Number>(this.opValue(operation, (Element) struct, (String) key, amount));
        } else if (struct instanceof List) {
            return new Atom<Number>(this.opValue(operation, (List) struct, (Integer) key, amount));
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage("Second argument must be a list, map, or element"));
        }

    }


    private Number opValue(final String operation, final Map map, final Object key, final Number amount) {
        Object object = map.get(key);
        Number value;
        if (null == object || !(object instanceof Number))
            value = 0;
        else
            value = (Number) object;

        if (operation.equals(ADD)) {
            map.put(key, new Addition(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(SUBTRACT)) {
            map.put(key, new Subtraction(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(MULTIPLY)) {
            map.put(key, new Multiplication(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(DIVIDE)) {
            map.put(key, new Division(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(MODULO)) {
            map.put(key, new Modulo(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage(OPERATION_ERROR));
        }
        return (Number) map.get(key);

    }

    private Number opValue(final String operation, final Element element, final String key, final Number amount) {
        Object object = element.getProperty(key);
        Number value;
        if (null == object || !(object instanceof Number))
            value = 0;
        else
            value = (Number) object;


        if (operation.equals(ADD)) {
            element.setProperty(key, new Addition(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(SUBTRACT)) {
            element.setProperty(key, new Subtraction(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(MULTIPLY)) {
            element.setProperty(key, new Multiplication(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(DIVIDE)) {
            element.setProperty(key, new Division(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(MODULO)) {
            element.setProperty(key, new Modulo(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage(OPERATION_ERROR));
        }
        return (Number) element.getProperty(key);
    }

    private Number opValue(final String operation, final List list, final Integer index, final Number amount) {
        if (list.size() < index + 1)
            throw new RuntimeException("list index out of range");

        Object object = list.get(index);
        Number value;
        if (null == object || !(object instanceof Number))
            value = 0;
        else
            value = (Number) object;

        if (operation.equals(ADD)) {
            list.set(index, new Addition(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(SUBTRACT)) {
            list.set(index, new Subtraction(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(MULTIPLY)) {
            list.set(index, new Multiplication(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(DIVIDE)) {
            list.set(index, new Division(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else if (operation.equals(MODULO)) {
            list.set(index, new Modulo(UnaryOperation.createUnaryOperation(value), UnaryOperation.createUnaryOperation(amount)).compute().getValue());
        } else {
            throw new RuntimeException(this.createUnsupportedArgumentMessage(OPERATION_ERROR));
        }
        return (Number) list.get(index);
    }


    public String getFunctionName() {
        return FUNCTION_NAME;
    }
}
