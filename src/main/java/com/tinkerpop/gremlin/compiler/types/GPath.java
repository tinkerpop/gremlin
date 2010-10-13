package com.tinkerpop.gremlin.compiler.types;

import com.tinkerpop.gremlin.compiler.context.GremlinScriptContext;
import com.tinkerpop.gremlin.compiler.pipes.GremlinRangeFilterPipe;
import com.tinkerpop.gremlin.compiler.util.Tokens;
import com.tinkerpop.pipes.*;

import javax.script.Bindings;
import javax.script.ScriptContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel A. Yaskevich
 */
final public class GPath extends DynamicEntity implements Iterable, Comparable {

    private Atom root;
    private Object persistentRoot = null;
    private static final String COMMA_SPACE = ", ";
    private static final String LEFT_ANGLE = "<";
    private static final String RIGHT_ANGLE = ">";

    private final List<Pipe> pipes;
    private Pipeline pipeline;
    private final Set<Object> previouslyFetched;
    private boolean startsFromRootIdentifier = false;
    private final GremlinScriptContext context;
    private final Bindings bindings;
    
    public GPath(final Atom root, final List<Pipe> pipes, final GremlinScriptContext context) {
        this.root = root;
        this.pipes = pipes;
        this.previouslyFetched = new HashSet<Object>();
        this.context = context;
        this.bindings = this.context.getBindings(ScriptContext.ENGINE_SCOPE);

        if (!(root instanceof DynamicEntity)) {
            if (pipes.get(0) instanceof IdentityPipe) {
                if (this.bindings.get(Tokens.IN_BLOCK) == null)
                    this.root = new Atom<Object>(bindings.get(Tokens.ROOT_VARIABLE));
                
                this.startsFromRootIdentifier = true;
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
        if (this.persistentRoot == null || bindings.get(Tokens.IN_BLOCK) != null) {
            this.persistentRoot = this.root.getValue();
        }

        final Object root = this.persistentRoot;

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

    public Atom getRoot() {
        return (persistentRoot == null) ? this.root : new Atom<Object>(this.persistentRoot);
    }

    /**
     * @param point "pointer to the updated root"
     */
    public void setRoot(Object point) {
        if (this.startsFromRootIdentifier) {
            this.persistentRoot = point;
        } else if (this.root instanceof Var) {
            // re-caching root variable
            this.persistentRoot = this.root.getValue();
        }
    }

    public String toString() {
        final Object result = this.getValue();
        
        if (result instanceof Iterable) {
            String out = "";

            for (Object o : (Iterable) this.getValue())
                out += o.toString() + COMMA_SPACE;

            return LEFT_ANGLE + out.substring(0, out.length() - 2) + RIGHT_ANGLE;
        }

        return result.toString();
    }
}
