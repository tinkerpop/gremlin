package com.tinkerpop.gremlin.steps;

import java.util.Collection;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public interface Steps {

    public Step getStep(String stepName);

    public void addStep(Step step);

    public Collection<Step> getSteps();

}
