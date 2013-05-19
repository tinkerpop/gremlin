package com.tinkerpop.gremlin.pipes.transform;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.pipes.util.StartPipe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class GremlinStartPipe extends StartPipe {

    private final boolean startIsGraph;

    public GremlinStartPipe(final Object object) {
        super(object);
        this.startIsGraph = object instanceof Graph;
    }

    public List getCurrentPath() {
        return this.startIsGraph ? new ArrayList() : super.getCurrentPath();
    }
}
