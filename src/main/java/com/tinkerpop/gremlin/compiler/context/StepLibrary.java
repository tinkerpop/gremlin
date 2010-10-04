package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.compiler.util.StringHelper;
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
                this.registerStep(step);
            }
        }
    }

    public void loadSteps(final String stepsClassName) throws RuntimeException {
        try {
            Class functionsClass = Class.forName(StringHelper.clearQuotes(stepsClassName));
            Steps steps = (Steps) functionsClass.getConstructor().newInstance();
            this.registerSteps(steps);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load " + stepsClassName);
        }
    }

    public void registerSteps(final Steps steps) {
        for (Step step : steps.getSteps()) {
            this.registerStep(step);
        }
    }

    public void registerStep(final Step step) {
        this.put(step.getStepName(), step);
    }

    public Step getStep(final String stepName) {
        Step step = this.get(stepName);
        if (null == step)
            throw new RuntimeException("Unregistered step: " + stepName);
        else
            return step;
    }
}
