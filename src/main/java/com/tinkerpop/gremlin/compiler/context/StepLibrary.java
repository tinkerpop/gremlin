package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.steps.Step;
import com.tinkerpop.gremlin.steps.Steps;

import java.util.HashMap;
import java.util.ServiceLoader;

/**
 * @author Marko A. Rodriguez
 */
public class StepLibrary extends HashMap<String, Step> {

    public StepLibrary() {
        final ServiceLoader<Steps> stepsService = ServiceLoader.load(Steps.class);

        for (final Steps steps : stepsService) {
            for (final Step step : steps.getSteps()) {
                this.registerStep(step.getStepName(), step);
            }
        }
    }

    public void registerStep(final String stepName, final Step step) {
        this.put(stepName, step);
    }

    public Step getStep(final String stepName) {
        return this.get(stepName);
    }

    public boolean isStep(final String stepName) {
        return (this.get(stepName) != null);
    }
}
