package com.tinkerpop.gremlin.compiler.context;

import com.tinkerpop.gremlin.steps.Step;

import java.util.HashMap;
import java.util.Map;

public class StepLibrary {

    private Map<String, Step> paths;

    public StepLibrary() {
        this.paths = new HashMap<String, Step>();
    }

    public void registerStep(final String id, final Step step) {
        this.paths.put(id, step);
    }

    public Step getStep(final String id) {
        return this.paths.get(id);
    }

    public boolean isStep(final String id) {
        return (this.paths.get(id) != null);
    }
}
