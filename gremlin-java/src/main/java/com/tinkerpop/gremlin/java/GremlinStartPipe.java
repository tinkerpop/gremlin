package com.tinkerpop.gremlin.java;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.pipes.IdentityPipe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinStartPipe extends IdentityPipe {

    private final boolean startIsGraph;

    public GremlinStartPipe(final Object start) {
        this.startIsGraph = start instanceof Graph;
    }

    public List getCurrentPath() {
        return this.startIsGraph ? new ArrayList() : super.getCurrentPath();
    }
}
