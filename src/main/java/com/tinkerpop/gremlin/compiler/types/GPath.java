package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.Tokens;
import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.context.VariableLibrary;
import com.tinkerpop.gremlin.compiler.pipes.GremlinRangeFilterPipe;
import com.tinkerpop.pipes.MultiIterator;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.Pipeline;
import com.tinkerpop.pipes.SingleIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel A. Yaskevich
 */
final public class GPath extends DynamicEntity implements Iterable, Comparable {

    private final Atom<Object> root;
    private Object persistentRoot = null;
    private static final String COMMA_SPACE = ", ";
    private static final String LEFT_ANGLE = "<";
    private static final String RIGHT_ANGLE = ">";

    private final List<Pipe> pipes;
    private Pipeline pipeline;
    private final Set<Object> previouslyFetched;

    public GPath(final Atom<Object> root, final List<Pipe> pipes, final GremlinScriptContext context) {
        this.root = root;
        this.pipes = pipes;
        this.previouslyFetched = new HashSet<Object>();
        
        if (!(root instanceof DynamicEntity)) {
            if (root.toString().equals(".") && root.isIdentifier()) {
                final VariableLibrary variables = context.getVariableLibrary();
                final Atom rootVariable = (Atom) variables.get(Tokens.ROOT_VARIABLE); 
                this.persistentRoot = (rootVariable == null) ? null : rootVariable.getValue();
            }
        }
    }

    protected Object value() {
        Object top;
        Iterator pipeline = this.iterator();

        if (pipeline.hasNext())
            top = pipeline.next();
        else
            return null;

        if (pipeline.hasNext()) {
            this.previouslyFetched.add(top);
            return this;
        } else
            return top;
    }

    public Iterator iterator() {
        if (this.pipeline == null || !this.pipeline.hasNext()) {
            for (Pipe p : this.pipes) {
                if (p instanceof GremlinRangeFilterPipe) {
                    ((GremlinRangeFilterPipe) p).reset();
                }
            }

            this.pipeline = new Pipeline(this.pipes);
            this.pipeline.setStarts(this.pipelineRoot());
        } else if (this.pipeline.hasNext()) {
            return new MultiIterator<Object>(this.previouslyFetched.iterator(), pipeline);
        }

        return this.pipeline;
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

    public int compareTo(Object object) {
        if (object instanceof Comparable) {
            return ((Comparable) object).compareTo(this.iterator().next());
        } else {
            return 0;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Iterable) {
            Iterator itty = ((Iterable) o).iterator();

            for (Object element : this) {
                if (itty.hasNext()) {
                    if (!element.equals(itty.next()))
                        return false;
                } else {
                    return false;
                }
            }

            // if there are still elements left in the comparable object
            // when gpath is out of the elements return false
            if (itty.hasNext()) return false;
        } else
            return super.equals(o);

        return true;
    }

    public List<Pipe> getPipes() {
        return this.pipes;
    }

    public Atom<Object> getRoot() {
        return (persistentRoot == null) ? this.root : new Atom<Object>(this.persistentRoot);
    }
    /**
     * This method should be used only inside of Pipes
     *
     * @param point "pointer to the updated root"
     */
    public void setRoot(Object point) {
        if (root.isIdentifier() && root.toString().equals(".")) {
            this.persistentRoot = point;
        }
    }

    public String toString() {
        String result = "";

        for (Object o : this)
            result += o.toString() + COMMA_SPACE;

        return LEFT_ANGLE + result.substring(0, result.length() - 2) + RIGHT_ANGLE;
    }
}
