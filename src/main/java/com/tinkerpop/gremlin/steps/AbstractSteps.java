package com.tinkerpop.gremlin.steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class AbstractSteps implements Steps {

    protected List<Step> steps = new ArrayList<Step>();

    public Step getStep(final String stepName) throws RuntimeException {
        for (final Step step : this.steps) {
            if (step.getStepName().equals(stepName))
                return step;
        }
        throw new RuntimeException("Unregistered step: " + stepName);
    }

    public void addStep(final Step step) {
        this.removeByStepName(step.getStepName());
        this.steps.add(step);
    }

    private void removeByStepName(final String stepName) {
        int index = -1;
        for (int i = 0; i < this.steps.size(); i++) {
            final Step step = this.steps.get(i);

            if (step.getStepName().equals(step))
                index = i;
        }
        if (index != -1)
            this.steps.remove(index);
    }

    public Collection<Step> getSteps() {
        return this.steps;
    }
}