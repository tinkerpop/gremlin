package com.tinkerpop.gremlin.steps;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PlaySteps extends AbstractSteps {

    public PlaySteps() {
        this.steps.add(new Step("play-string", PlayStringPipe.class, null));
    }
}
