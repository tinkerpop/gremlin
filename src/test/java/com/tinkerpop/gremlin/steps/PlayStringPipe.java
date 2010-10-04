package com.tinkerpop.gremlin.steps;

import com.tinkerpop.pipes.AbstractPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PlayStringPipe extends AbstractPipe<String, String> {

    public String processNextStart() {
        return this.starts.next().concat("a");
    }
}
