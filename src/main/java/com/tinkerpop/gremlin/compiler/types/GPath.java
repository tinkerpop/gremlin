package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.pipes.GremlinPipesHelper;
import com.tinkerpop.gremlin.compiler.pipes.GremlinRangeFilterPipe;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pavel A. Yaskevich
 */
public class GPath implements Iterable, Comparable {

    private final List<Pipe> pipes;
    private final Atom<Object> root;
    private Object persistentRoot = null;

    public GPath(final Atom<Object> root, final List<Pipe> pipes, final GremlinScriptContext context) {
        this.root  = root;
        this.pipes = pipes;
        
        if (!(root instanceof DynamicEntity)) {
            if (root.toString().equals(".") && root.isIdentifier()) {
                final VariableLibrary variables = context.getVariableLibrary();
                this.persistentRoot = ((Atom) variables.get(Tokens.ROOT_VARIABLE)).getValue();
            }
        }
    }
    
    public Iterator iterator() {
        for(Pipe p : this.pipes) {
            if (p instanceof GremlinRangeFilterPipe) {
                ((GremlinRangeFilterPipe) p).reset();
            }
        }
        
        Pipeline pipeline = new Pipeline(this.pipes);
        pipeline.setStarts(this.pipelineRoot());
        return pipeline;
    }

    public List<Object> toList() {
        Iterator current = this.iterator();
        List<Object> results = new ArrayList<Object>();
        
        while(current.hasNext()) {
            results.add(current.next());    
        }

        return results;
    }

    public int compareTo(Object o) {
        List<Object> list = this.toList();

        if (list.size() == 1) {
            Object c = list.get(0);

            if (c == null) return -1;
            if (c instanceof Comparable && o instanceof Comparable)
                return ((Comparable<Object>) c).compareTo(o);
        }

        throw new ClassCastException(this + " and " + o + " are incomparable objects");
    }

    public boolean equals(Object o) {
        return this.toList().equals(convertToList(o));
    }

    protected Iterable convertToList(Object operand) {
        if (operand instanceof GPath) {
            return ((GPath) operand).toList();
        } else if (operand instanceof Iterable) {
            return (Iterable) operand;
        } else {
            List<Object> list = new ArrayList<Object>();
            list.add(operand);
            return list;
        }
    }

    private Iterator pipelineRoot() {
        final Object root = (persistentRoot == null) ? this.root.getValue() : this.persistentRoot;
        
        if (root instanceof Iterable) {
            return ((Iterable) root).iterator();
        } else if (root instanceof Iterator) {
            return (Iterator) root;
        } else {
            return new SingleIterator<Object>(root);
        }
    }
}
