package com.tinkerpop.gremlin.model;

import com.tinkerpop.gremlin.BaseTest;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @version 0.1
 */
public abstract class ModelTestSuite extends BaseTest {

    protected SuiteConfiguration config;

    public ModelTestSuite() {}

    public ModelTestSuite(SuiteConfiguration config) {
        this.config = config;
    }

    protected String convertId(String id) {
        if (this.config.requiresRDFIds) {
            return "http://" + id;
        } else {
            return id;
        }
    }

    public void testTrue() {
        assertTrue(true);
    }
}
