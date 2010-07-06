package com.tinkerpop.gremlin.compiler;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.gremlin.compiler.functions.Function;
import com.tinkerpop.gremlin.compiler.operations.Operation;
import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel A. Yaskevich
 */
public class Atom {

    private Object val;

    /* for not persistent variable calls */
    private String variableName;

    /* for not persistent function calls */
    private Function function;
    private List<Operation> functionParams;

    private boolean persistent = true;

    /* identifier and property used in gpath */
    private boolean identifier = false;
    private boolean property = false;

    private Type type = Type.REGULAR;
    
    public enum Type {
        FUNCTION, VARIABLE, GPATH, REGULAR
    }

    // required for Pipes support
    private Object gpathStartPoint;

    public Atom(Object value) {
        this.val = value;

        // string preprocessing
        if (this.isString()) {
            String result = "";
            String stringVal = (String) this.val;

            for (int i = 0; i < stringVal.length(); i++) {
                Character currChar = stringVal.charAt(i);

                if ((i == 0 || i == stringVal.length() - 1) && (currChar.equals('"') || currChar.equals('\'')))
                    continue;

                result += stringVal.charAt(i);
            }

            this.val = result;
        }
    }

    public Object getValue() {
        if (this.gpathStartPoint != null) {
            Pipeline pipeline = (Pipeline)this.val;
            pipeline.setStarts(GremlinPipesHelper.pipelineStartPoint(this.gpathStartPoint));
            
            return pipeline;
        } else {
            return this.val;
        }
    }

    public boolean isString() {
        return isClassOf(String.class);
    }

    public boolean isNumber() {
        return isClassOf(Double.class);
    }

    public boolean isBoolean() {
        return isClassOf(Boolean.class);
    }

    public boolean isNull() {
        return null == this.val;
    }

    public boolean isList() {
        return isClassOf(List.class);
    }

    public boolean isMap() {
        return isClassOf(Map.class);
    }

    public boolean isIterable() {
        return isClassOf(Iterable.class);
    }

    public boolean isFunctionCall() {
        return null != this.function;
    }

    public boolean isGraph() {
        return isClassOf(Graph.class);
    }

    public boolean isElement() {
        return isClassOf(Element.class);
    }

    public boolean isVertex() {
        return isClassOf(Vertex.class);
    }

    public boolean isEdge() {
        return isClassOf(Edge.class);
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public boolean isIdentifier() {
        return this.identifier;
    }

    public boolean isProperty() {
        return this.property;
    }

    public void setPersistent(final boolean flag) {
        this.persistent = flag;
    }

    public void setVariableName(final String name) {
        this.variableName = name;
        this.type = Type.VARIABLE;
    }

    public void setFunction(final Function fn, final List<Operation> params) {
        this.function = fn;
        this.functionParams = params;
        this.type = Type.FUNCTION;
    }

    public void setStartPoint(Object gpathStartPoint) {
        this.type = Type.GPATH;
        this.persistent = true; 
        this.gpathStartPoint = gpathStartPoint;    
    }
    
    public void setIdentifier(final boolean flag) {
        this.identifier = flag;
    }

    public void setProperty(final boolean flag) {
        this.property = flag;
    }

    public Atom recalculated() {
        Atom result = null;

        try {
            if (this.type == Type.VARIABLE) {
                result = GremlinEvaluator.getVariable(this.variableName);
            } else if (this.type == Type.FUNCTION) {
                result = this.function.compute(this.functionParams);
            } else {
                result = this;
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return result;
    }

    @SuppressWarnings("rawtypes")
    private boolean isClassOf(final Class klass) {
        return (this.isNull()) ? false : ((klass.isAssignableFrom(this.val.getClass())) ? true : false);
    }

    public boolean equals(Object object) {
        if (object instanceof Atom) {
            return (((Atom) object).getValue().equals(this.val));
        }
        return false;
    }

    public int hashCode() {
        return this.val.hashCode();
    }

    public String toString() {
        return (this.val == null) ? "null" : this.val.toString();
    }

}
